/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

import java.util.*;
import java.io.*;

/**
 *
 * @author Jordan
 */
public class modellist implements modelkamus
{
    private isilist [] list;
    private int jumlah;
    private Map<String,Integer> bahasa = new HashMap();
    private String [] namabahasa;
    
    public modellist ()
    {
    }
    
    public modellist (int Jumlah, String [] Bahasa) 
    {
        jumlah=Jumlah;
        list = new isilist[jumlah];
        namabahasa = new String[Bahasa.length];
        for (int i=0;i<jumlah;++i)
        {
            list[i] = new isilist();
        }
        for (int i=0;i<Bahasa.length;++i)
        {
            bahasa.put(Bahasa[i],i);
            namabahasa[i]=Bahasa[i];
        }
    }
    
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
                        list[bhs1].tambah(s1,s2,s3);
                        list[bhs2].tambah(s2,s1,s3);
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
            System.err.println("Error: "+e.getMessage());
        }
    }
    
    public int tambahterjemahan (String Bahasa1, String Bahasa2, String s1, String s2, String s3)
    {
        if ((bahasa.get(Bahasa1)!=null)&&(bahasa.get(Bahasa2)!=null))
        {
            int posisi1 = bahasa.get(Bahasa1);
            int posisi2 = bahasa.get(Bahasa2);

            boolean cek = false;
            list[posisi1].tambah(s1,s2,s3);
            list[posisi2].tambah(s2,s1,s3);
            return 0;
        }
        return -1;
    }
    
    public Vector<String> getterjemahan (String Bahasa, String s)
    {
        if (bahasa.get(Bahasa)!=null)
        {
            int posisi = bahasa.get(Bahasa);
            return list[posisi].cariarti(s);
        }
        return new Vector();
    }
    
    public Vector<String> gettipe (String b, String s)
    {
        if (bahasa.get(b)!=null)
        {
            int pos = bahasa.get(b);
            return list[pos].caritipe(s);
        }
        return new Vector();
    }
    
    public Vector<String> detectbahasa (String s)
    {
        Vector<String> value = new Vector<String>();
        for (int i=0;i<jumlah;++i)
        {
            Vector<String> cek = list[i].cariarti(s);
            if (cek!=null)
            {
                    value.add(namabahasa[i]);
            }
        }
        return value;
    }
    
    public void cetakterurut (String Bahasa)
    {
        
        if (bahasa.get(Bahasa)!=null)
        {
            int pos = bahasa.get(Bahasa);
            viewkamus view = new viewkamus();
            view.cetak(list[pos].tampilterurut(""));
        }
    }
    
    public void writeoutput (String Bahasa, String namafile)
    {
        try
        {
            int bhs = bahasa.get(Bahasa);
            // Create file 
            FileWriter fstream = new FileWriter(namafile);
            BufferedWriter out = new BufferedWriter(fstream);

            out.write(list[bhs].tampilsimpan(""));
            //Close the output stream
            out.close();
        }
        catch (Exception e)
        {	//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
