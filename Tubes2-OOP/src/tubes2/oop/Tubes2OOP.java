/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes2.oop;


import java.util.*;
import java.io.*;
import java.lang.reflect.*;

/**
 * Kelas utama kamus versi 1
 * @author Jordan, Adriel, and Wilson
 */
public class Tubes2OOP {

    /**
     * Main program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Console console = System.console();
        String [] bahasa = {"Indonesia","Inggris"};
        modelmapone model = new modelmapone(2,bahasa);
        viewmapone view = new viewmapone();

        model.readinput(bahasa[0],bahasa[1],"DicIndonesiaEnglish.txt");

        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        String bahasadef="Indonesia";
        String bahasadua="Inggris";
        int i=7;
        do
        {
                i = view.printmenu(in);
                switch (i)
                {
                        case 1:	{
                                    view.cetak("Input Kata : ");
                                    String s1 = view.getline(brin);
                                    view.cetak("Terjemahan Kata : ");
                                    String s2 = view.getline(brin);
                                    view.cetak("Tipe Kata : ");
                                    String s3 = view.getline(brin);
                                    int j = model.tambahterjemahan(bahasadef,bahasadua,s1,s2,s3);
                                    if (j==0)
                                            view.cetakln("Entry baru berhasil disimpan.");
                                    else
                                            view.cetakln("Entry baru gagal disimpan.");
                                    break;
                                }
                        case 2:	{
                                    String temp = bahasadef;
                                    bahasadef = bahasadua;
                                    bahasadua = temp;
                                    view.cetakln("Bahasa " + bahasadua + " -> Bahasa " + bahasadef);
                                    break;
                                }			
                        case 3: {
                                    view.printpetunjuk();
                                    view.cetak("Input Kata : ");
                                    String s = view.getline(brin);
                                    String hasil = model.getterjemahan(bahasadef,s);
                                    String tipe = model.gettipe(s);
                                    if (hasil.compareTo("")!=0)
                                    {
                                            view.cetak("Terjemahan Kata : ");
                                            view.cetakln(hasil);
                                            view.cetak("Tipe Kata : ");
                                            view.cetakln(tipe);
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

                                    String [] hasil = model.detectmap(s);
                                    int j = 0;
                                    for (String temp : hasil)
                                    {
                                            j++;
                                    }
                                    j--;
                                    if (j!=0)
                                    {
                                            view.cetak("Kata dalam ");
                                            for (int k=0;k<j;k++)
                                            {
                                                    view.cetak(hasil[k]);
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
                                    model.cetakmap(bahasadef);
                                    break;
                                }
                        case 6:	{
                                    try
                                    {
                                        Class c = TreeMap.class;
                                        Method m[] = c.getDeclaredMethods();
                                        Field f[] = c.getDeclaredFields();
                                        view.cetakln("Struktur TreeMap");
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
        in.close();
    }
}
