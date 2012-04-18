/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

/**
 *
 * @author Jordan, Adriel, and Wilson
 */

import java.util.*;
import java.io.*;

/**
 * Kelas model dari kamus ver 1
 * @author Jordan, Adriel, and Wilson
 */
public class modelmap implements modelkamus
{
    
    private SortedMap<String,String> map[];
    private int jumlah;
    private Map<String,Integer> bahasa = new HashMap();
    private String [] namabahasa;
    
    /**
     * constructor tanpa parameter untuk model map
     */
    public modelmap ()
    {
       jumlah = 0;
    }
    
    /**
     * constructor dengan parameter untuk model map
     * @param Jumlah Jumlah bahasa yang ada
     * @param Bahasa Nama-nama bahasa
     */
    public modelmap (int Jumlah, String [] Bahasa) 
    {
        jumlah=Jumlah;
        map = new SortedMap[jumlah];
        namabahasa = new String[Bahasa.length];
        for (int i=0;i<jumlah;++i)
        {
            map[i] = new TreeMap();
        }
        for (int i=0;i<Bahasa.length;++i)
        {
            bahasa.put(Bahasa[i],i);
            namabahasa[i]=Bahasa[i];
        }
    }

    /**
     * prosedur untuk mencetak entri kamus dalam map
     * @param Bahasa map bahasa yang dicetak
     */
    public void cetakterurut (String Bahasa)
    {  
        if (bahasa.get(Bahasa)!=null)
        {
            int pos = bahasa.get(Bahasa);
            viewkamus view = new viewkamus();
            Iterator iterator = map[pos].keySet().iterator();
            while (iterator.hasNext()) 
            {
                String key = (String)iterator.next();
                String [] arti = map[pos].get(key).split(" ");
                int j = 0;
                while (j<arti.length)
                {
                    view.cetak(key+" : "+arti[j]+" (");
                    j++;
                    view.cetakln(arti[j]+")");
                    j++;
                }
            }
        }
    }
    
    /**
     * fungsi untuk mendeteksi ada bahasa apa saja dalam map
     * @param s Kata yang ingin dideteksi
     * @return Bahasa-bahasa yang memiliki kata tersebut
     */
    public Vector<String> detectbahasa (String s)
    {
        Vector<String> value = new Vector<String>();
        for (int i=0;i<jumlah;++i)
        {
            if (map[i].get(s)!=null)
            {
                value.add(namabahasa[i]);
            }
        }
        return value;
    }

    /**
     * getter value untuk map tipe
     * @param s kata yang ingin diketahui tipenya
     * @return tipe dari s
     */
    public Vector<String> gettipe (String bhs, String s)
    {
        if (bahasa.get(bhs)!=null)
        {
            int pos = bahasa.get(bhs);
            if (map[pos].get(s)!=null)
            {
                String [] isi = map[pos].get(s).split(" ");
                Vector<String> hasil = new Vector<String>();
                int j = 1;
                while (j<isi.length)
                {
                    hasil.add(isi[j]);
                    j += 2;
                }
                return hasil;
            }
        }
        return new Vector();
    }

        /**
     * fungsi untuk memperoleh terjemahan bahasa dari bahasa yg diinginkan
     * @param Bahasa bahasa yang ingin diterjemahkan
     * @param s kata yang ingin diterjemahkan
     * @return terjemahan dari bahasa yang diingingkan
     */
    public Vector<String> getterjemahan (String Bahasa, String s)
    {
        if (bahasa.get(Bahasa)!=null)
        {
            int pos = bahasa.get(Bahasa);
            if (map[pos].get(s)!=null)
            {
                String [] isi = map[pos].get(s).split(" ");
                Vector<String> hasil = new Vector<String>();
                int j = 0;
                while (j<isi.length)
                {
                    hasil.add(isi[j]);
                    j += 2;
                }
                return hasil;
            }
        }
        return new Vector();
    }
    
    /**
     * fungsi untuk mengisi entri kata dan terjemahan baru, mengembalikan 0 jika kata belum ada, mengembalikan -1 jika entri kata sudah ada
     * @param Bahasa1 bahasa pertama
     * @param Bahasa2 bahasa kedua
     * @param s1 kata pertama
     * @param s2 kata kedua
     * @param s3 tipe kata
     * @return nilai yang menandakan apakah kata berhasil dimasukkan
     */
    public int tambahterjemahan (String Bahasa1, String s1, String s2, String s3)
    {
        String [] temp = Bahasa1.split(" ");
        String Bahasa2 = new String();
        if (Bahasa1.contains(" "))
            Bahasa2 = temp[0]+" "+temp[1];

        if ((bahasa.get(Bahasa1)!=null)&&(bahasa.get(Bahasa2)!=null))
        {
            int posisi1 = bahasa.get(Bahasa1);
            int posisi2 = bahasa.get(Bahasa2);

            boolean cek = false;
            if (map[posisi1].get(s1)==null)
            {
                String tempS = s2 + " " + s3;
                map[posisi1].put(s1,tempS);
                cek = true;
            } else {
                String tempS = map[posisi1].get(s1);
                tempS = tempS + " " + s2 + " " + s3;
                map[posisi1].put(s1,tempS);
                cek = true;
            }
            if (map[posisi2].get(s2)==null)
            {
                String tempS = s1 + " " + s3;
                map[posisi2].put(s2,tempS);
                cek = true;
            } else {
                String tempS = map[posisi2].get(s2);
                tempS = tempS + " " + s1 + " " + s3;
                map[posisi2].put(s2,tempS);
                cek = true;
            }
            if (cek)
                return 0;
        }
        return -1;
    }

    /**
     * getter untuk entri ke-i pada map Use modelmapone(int,String[]) to move a piece.
     * @param i id map yang diinginkan
     * @return map yang diinginkan
     */
    public SortedMap getmap (int i)
    {
        if (i<jumlah)
            return map[i];
        return null;
    }

    /**
     * setter untuk map m pada indeks i
     * @param m map yang ingin diset
     * @param i id map yang ingin diset
     */
    public void setmap (SortedMap<String,String> m, int i)
    {
        if (m!=null)
        {
            Iterator iterator = m.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String key = (String)iterator.next();
                if (map[i].get(key)==null)
                    map[i].put(key,m.get(key));
            }
        }
    }

    /**
     * prosedur untuk membaca file dari luar
     * @param bahasa1 bahasa pertama
     * @param bahasa2 bahasa kedua
     * @param namafile nama file.txt yang mengandung kamus dari bahasa1 ke bahasa2
     */
    public void readinput (String bahasa1, String bahasa2, String namafile)
    {
        try
        {
            int bhs1 = bahasa.get(bahasa1);
            int bhs2 = bahasa.get(bahasa2);

            FileInputStream fstream = new FileInputStream(namafile);
            DataInputStream fin = new DataInputStream(fstream);
            BufferedReader brf = new BufferedReader(new InputStreamReader(fin));

            String s1="";
            String s2="";
            String s3="";
            String tempS="";
            boolean cek = false;
            boolean cekspecial = false;
            int tempint;
            while ((tempint=brf.read())!=-1)
            {
                String temp = ""+(char)tempint;
                if (temp.compareTo(")")==0)
                    cekspecial = false;
                else if (cekspecial)
                    s3 = s3+temp;
                else if (temp.compareTo("(")==0)
                    cekspecial = true;
                else if (temp.compareTo(":")==0)
                    cek = true;
                else if (temp.compareTo(".")==0)
                {
                    cek = false;
                    if (map[bhs1].get(s1)==null)
                    {
                        tempS = s2 + " " + s3;
                        map[bhs1].put(s1,tempS);
                    } else {
                        tempS = map[bhs1].get(s1);
                        tempS = tempS + " " + s2 + " " + s3;
                        map[bhs1].put(s1,tempS);
                    }
                    if (map[bhs2].get(s2)==null)
                    {
                        tempS = s1 + " " + s3;
                        map[bhs2].put(s2,tempS);
                    } else {
                        tempS = map[bhs2].get(s2);
                        tempS = tempS + " " + s1 + " " + s3;
                        map[bhs2].put(s2,tempS);
                    }
                }
                else if (cek)
                    s2 = s2+temp;
                else if (temp.compareTo("\n")!=0)
                    s1 = s1+temp;
                else
                {
                    s1="";
                    s2="";
                    s3="";
                }
            }			
            fin.close();
        }
        catch (Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }

    /**
     * prosedur untuk menuliskan isi map sekarang ke file luar
     * @param Bahasa bahasa yang ingin ditulis
     * @param namafile nama file
     */
    public void writeoutput (String Bahasa, String namafile)
    {
        try
        {
            int bhs = bahasa.get(Bahasa);
            // Create file 
            FileWriter fstream = new FileWriter(namafile);
            BufferedWriter out = new BufferedWriter(fstream);

            Iterator iterator = map[bhs].keySet().iterator();
            while (iterator.hasNext()) 
            {
                String key = (String)iterator.next();
                String [] arti = map[bhs].get(key).split(" ");
                int j = 0;
                while (j<arti.length)
                {
                    j++;
                    out.write(key+"("+arti[j]+"):");
                    j--;
                    out.write(arti[j]+".\n");
                    j+=2;
                }
            }

            //Close the output stream
            out.close();
        }
        catch (Exception e)
        {	//Catch exception if any
            System.err.println("Error : " + e.getMessage());
        }
    }
}
