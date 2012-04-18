/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;


import java.util.*;
import java.io.*;
import java.lang.reflect.*;

/**
 * Kelas utama kamus versi 1
 * @author Jordan, Adriel, and Wilson
 */
public class KamusDewa {

    /**
     * Main program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Console console = System.console();
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            Scanner in = new Scanner(System.in);

            String [] bahasa = {"Indonesia Inggris","Inggris Indonesia","Indonesia Jepang","Jepang Indonesia","Inggris Jepang","Jepang Inggris"};
            viewkamus view = new viewkamus();

            boolean cekpilihan = true;
            modelkamus model = new modelmap(6,bahasa);
            int pilihan;
            do
            {
                pilihan = view.printpilihan(in);
                if (pilihan==1)
                {
                    cekpilihan = false;
                }
                else if (pilihan==2)
                {
                    model = new modellist(6,bahasa);
                    cekpilihan = false;
                }
                else if (pilihan==-1)
                {
                    view.cetakln("Ada kesalahan.");
                    cekpilihan = false;
                }
            } while (cekpilihan);
            model.readinput(bahasa[0],bahasa[1],"DicIndonesiaEnglish.txt");
            model.readinput(bahasa[2],bahasa[3],"DicIndonesiaJepang.txt");
            model.readinput(bahasa[4],bahasa[5],"DicEnglishJepang.txt");
            String bahasadef="Indonesia Inggris";
            int i=7;
            do
            {
                view.printbahasadef(bahasadef);
                i = view.printmenu(in);
                switch (i)
                {
                    case 1:{
                                view.cetak("Input Kata : ");
                                String s1 = view.getline(brin);
                                view.cetak("Terjemahan Kata : ");
                                String s2 = view.getline(brin);
                                view.cetak("Tipe Kata : ");
                                String s3 = view.getline(brin);
                                Vector<String> buff = model.getterjemahan(bahasadef,s1);
                                if (buff.size()>0)
                                {
                                    if (model.tambahterjemahan(bahasadef,s1,s2,s3)==0)
                                            view.cetakln("Entry baru berhasil disimpan.");
                                    else
                                            view.cetakln("Entry baru gagal disimpan.");
                                }
                                else
                                {
                                    boolean cek = true;
                                    int j = 0;
                                    while ((cek)&&(j<buff.size()))
                                    {
                                        if (s2.equals(buff.get(j)))
                                            cek = false;
                                        j++;
                                    }
                                    if (cek)
                                    {
                                        if (model.tambahterjemahan(bahasadef,s1,s2,s3)==0)
                                            view.cetakln("Entry baru berhasil disimpan.");	
                                        else
                                            view.cetakln("Entry baru gagal disimpan.");
                                    }
                                    else
                                    {
                                        view.cetakln("Entry sudah ada.");
                                    }
                                }
                                break;
                            }
                    case 2:{
                                int hasil = view.printpilihanbahasa(in,bahasa,bahasadef,6);
                                if (hasil>=0)
                                {
                                    bahasadef = bahasa[hasil];
                                }
                                else
                                {
                                    view.cetakln("Kamus tidak diganti.");
                                }
                                view.printbahasadef(bahasadef);
                                break;
                            }			
                    case 3: {
                                view.printpetunjuk();
                                view.cetak("Input Kata : ");
                                String s = view.getline(brin);
                                Vector<String> hasil = model.getterjemahan(bahasadef,s);
                                Vector<String> tipe = model.gettipe(bahasadef,s);
                                if (hasil.size()>0)
                                {
                                   
                                    view.cetak("Terjemahan Kata : ");
                                    for (int j=0;j<hasil.size();++j)
                                    {
                                        view.cetakln(hasil.get(j)+" ("+tipe.get(j)+")");
                                    }
                                }
                                else
                                {
                                    view.cetakln("Kata tidak ada dalam database!");
                                }
                                break;
                            }
                    case 4:	{
                                view.cetak("Input Kata : ");
                                String s = view.getline(brin);
                                Vector<String> hasil = model.detectbahasa(s);

                                if (hasil.size()>0)
                                {
                                    view.cetak("Kata dalam ");
                                    for (int k=0;k<hasil.size();k++)
                                    {
                                        view.cetak(hasil.get(k));
                                    }
                                    view.cetakln("");
                                }
                                else
                                {
                                    view.cetakln("Kata tidak ada dalam database");
                                }
                                break;
                            }
                    case 5: {
                                model.cetakterurut(bahasadef);
                                break;
                            }
                    case 6:{
                                try
                                {
                                    Class c;
                                    if (pilihan==1)
                                        c = modelmap.class;
                                    else
                                        c = modellist.class;
                                    Method m[] = c.getDeclaredMethods();
                                    Field f[] = c.getDeclaredFields();
                                    view.cetakln("Struktur Data");
                                    view.cetakln("Attribut:");
                                    for (int j=0;j<f.length;j++)
                                    {
                                        view.cetakln(f[j].toString());
                                    }
                                    view.cetakln("Method");
                                    for (int j=0;j<m.length;j++)
                                    {
                                        view.cetakln(m[j].toString());
                                    }
                                }
                                catch (Throwable e)
                                {
                                    System.err.println(e);
                                }
                                break;
                            }
                    case 7: {
                                view.cetakln(" *** Terima Kasih sudah menggunakan program ini ***");
                                break;
                            }
                    default:{
                                view.cetakln("Perintah masukan salah");
                                break;
                            }
                }
            }while (i!=7);
            model.writeoutput(bahasa[0],"DicIndonesiaEnglish.txt");
            model.writeoutput(bahasa[2],"DicIndonesiaJepang.txt");
            model.writeoutput(bahasa[4],"DicEnglishJepang.txt");
            in.close();
        }
        catch (Throwable e)
        {
            System.err.println(e);
        }
    }
}
