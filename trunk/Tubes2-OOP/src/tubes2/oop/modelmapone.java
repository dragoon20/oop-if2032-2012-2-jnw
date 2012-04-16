
package tubes2.oop;

import java.util.*;
import java.io.*;
import java.util.Vector;

/**
 * Kelas model dari kamus ver 1
 * @author Jordan, Adriel, and Wilson
 */
public class modelmapone{
    
    private SortedMap<String,Vector<String[]>> map[];
    private int jumlah;
    private Map<String,Integer> bahasa = new HashMap();
    private String [] namabahasa;
    private Map tipe = new HashMap(); // noun, verb, adj, other

    /**
     * constructor tanpa parameter untuk model map
     */
    public modelmapone ()
    {
           jumlah = 0;
    }
    
    /**
     * constructor dengan parameter untuk model map
     * @param Jumlah Jumlah bahasa yang ada
     * @param Bahasa Nama-nama bahasa
     */
    public modelmapone (int Jumlah, String [] Bahasa) 
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
    public void cetakmap (String Bahasa)
    {
        
        if (bahasa.get(Bahasa)!=null)
        {
            int pos = bahasa.get(Bahasa);
            viewmapone view = new viewmapone();
            Iterator iterator = map[pos].keySet().iterator();
            while (iterator.hasNext()) 
            {
                    String key = (String)iterator.next();
                    view.cetakln(key + " : " + cetakvektor(map[pos].get(key)) + " (" + tipe.get(key) + ")");
            }
        }
    }
    
    public String cetakvektor (Vector<String[]> v) {
        String temp = v.get(0)[0] + v.get(0)[1];
        int i = 1;
        while (v.get(i)!=null) {
            temp = temp + "," + v.get(i)[0] + v.get(i)[1];
        }
        return temp;
    }
    
    /**
     * fungsi untuk mendeteksi ada bahasa apa saja dalam map
     * @param s Kata yang ingin dideteksi
     * @return Bahasa-bahasa yang memiliki kata tersebut
     */
    public String [] detectmap (String s)
    {
            String [] value = new String[jumlah];
            int j=0;
            for (int i=0;i<jumlah;++i)
            {
                    if (map[i].get(s)!=null)
                    {
                            value[j]=namabahasa[i];
                            j++;
                    }
            }
            if (j>0)
                return value;
            return null;
    }

    /**
     * getter value untuk map tipe
     * @param s kata yang ingin diketahui tipenya
     * @return tipe dari s
     */
    public String gettipe (String s)
    {
            if ((String) tipe.get(s)!=null)
                    return (String) tipe.get(s);
            return "";
    }

        /**
     * fungsi untuk memperoleh terjemahan bahasa dari bahasa yg diinginkan
     * @param Bahasa bahasa yang ingin diterjemahkan
     * @param s kata yang ingin diterjemahkan
     * @return terjemahan dari bahasa yang diingingkan
     */
    public Vector<String[]> getterjemahan (String Bahasa, String s)
    {
        if (bahasa.get(Bahasa)!=null)
        {
            int posisi = bahasa.get(Bahasa);
            if (map[posisi].get(s)!=null){
                    
                    return map[posisi].get(s);
            }
        }
        Vector<String[]> Vreturn = new Vector<String[]>();
        String[] stemp = null;
//        stemp[0] = ""; 
//        stemp[1] = ""; 
        Vreturn.add(stemp);
        return Vreturn;
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
    public int tambahterjemahan (String Bahasa1, String Bahasa2, String s1, String s2, String s3)
    {
        if ((bahasa.get(Bahasa1)!=null)&&(bahasa.get(Bahasa2)!=null))
        {
            int posisi1 = bahasa.get(Bahasa1);
            int posisi2 = bahasa.get(Bahasa2);

            boolean cek = false;
//            if (map[posisi1].get(s1)==null)
//            {
                Vector<String[]> tempV = new Vector<String[]>();
                tempV = map[posisi1].get(s1);
                String[] stemp = null;
                stemp[0] = s2;
                stemp[1] = s3;
                tempV.add(stemp);
                map[posisi1].put(s1,tempV);
                tipe.put(s1,s3);
//                cek = true;
//            }
//            if (map[posisi2].get(s2)==null)
//            {
                tempV = map[posisi1].get(s2);
                stemp[0] = s1;
                tempV.add(stemp);
                map[posisi2].put(s2,tempV);
                tipe.put(s2,s3);
                cek = true;
 //           }
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
    public void setmap (SortedMap<String,Vector<String[]>> m, int i)
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
                    Vector<String[]> tempV = new Vector<String[]>();
                    String[] stemp = new String[2];
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
                                    if (map[bhs1].get(s1)!=null)
                                    {
                                        tempV = map[bhs1].get(s1);
                                    }
                                        stemp[0] = s2;
                                        stemp[1] = s3;
                                        tempV.add(stemp);
                                        map[bhs1].put(s1,tempV);
                                        tipe.put(s1,s3);
//                                    }
                                    tempV = new Vector<String[]>();
                                    if (map[bhs2].get(s2)!=null)
                                    {
                                        tempV = map[bhs2].get(s2);
                                    }
                                        stemp[0] = s1;
                                        tempV.add(stemp);
                                        map[bhs2].put(s2,tempV);
                                        tipe.put(s2,s3);
//                                    }
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
                            out.write(key + "(" + tipe.get(key) + "):" + cetakvektor(map[bhs].get(key)) + ".\n");
                    }

                    //Close the output stream
                    out.close();
            }
            catch (Exception e)
            {	//Catch exception if any
                    System.err.println("Error: " + e.getMessage());
            }
    }
}
