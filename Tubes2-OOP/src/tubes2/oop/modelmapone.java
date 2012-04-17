
package tubes2.OOP;

import java.util.*;
import java.io.*;

/**
 * Kelas model dari kamus ver 1
 * @author Jordan, Adriel, and Wilson
 */
public class modelmapone{
    
    private SortedMap<String,String> map[];
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
			String temp = "";
			char ch;
            while (iterator.hasNext()) 
            {
                    String key = (String)iterator.next();
					int i = 0 ; int jmlspasi = 0; String key2 = key + " : ";
					while (i<map[pos].get(key).length()) {
						ch = map[pos].get(key).charAt(i);
						if (i == map[pos].get(key).length()-1) {
							key2 = key2 + ch + ") ";
							view.cetakln(key2);
							key2 = key + " + ";
						} else if (ch == ' ' && jmlspasi%2 == 1) {
							key2 = key2 + ") ";
							jmlspasi++;
							view.cetakln(key2);
							key2 = key + " + ";
						} else if (ch != ' ') {
							key2 = key2 + ch;
						} else if (ch == ' ' && jmlspasi%2 == 0) {
							key2 = key2 + " (";
							jmlspasi++;
						}
						i++;
					}
            }
        }
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
    public String[] getterjemahan (String Bahasa, String s)
    {
        if (bahasa.get(Bahasa)!=null)
        {
            int posisi = bahasa.get(Bahasa);
            if (map[posisi].get(s)!=null){
				String[] tempS;
				tempS = map[posisi].get(s).split(" ");
				return tempS;
            }
        }
        String [] Sreturn = null;
        return Sreturn;
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
            if (map[posisi1].get(s1)==null)
            {
                String tempS = s2 + " " + s3;
                map[posisi1].put(s1,tempS);
                tipe.put(s1,s3);
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
                tipe.put(s2,s3);
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
										tipe.put(s1,s3);
                                    } else {
										tempS = map[bhs1].get(s1);
										tempS = tempS + " " + s2 + " " + s3;
                                        map[bhs1].put(s1,tempS);
                                    }
                                    if (map[bhs2].get(s2)==null)
                                    {
										tempS = s1 + " " + s3;
										map[bhs2].put(s2,tempS);
										tipe.put(s2,s3);
                                    } else {
										tempS = map[bhs2].get(s2);
										tempS = tempS + " " + s1 + " " + s3;
                                        map[bhs2].put(s2,tempS);
                                    }
//									if (map[bhs1].get("apel")!=null)
//										System.out.println(map[bhs1].get("apel").get(0).getarti());
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
							int i = 0 ; int jmlspasi = 0; String key2 = key; String key3 = ""; char ch;
							while (i<map[bhs].get(key).length()) {
								ch = map[bhs].get(key).charAt(i);
								if (i == map[bhs].get(key).length()-1) {
									key2 = key2 + ch + ")";
									out.write(key2 + ":" + key3 + ".\n");
									key2 = key;
									key3 = "";
								} else if (ch == ' ' && jmlspasi%2 == 1) {
									key2 = key2 + ")";
									jmlspasi++;
									out.write(key2 + ":" + key3 + ".\n");
									key2 = key;
									key3 = "";
								} else if (ch != ' ' && jmlspasi%2 == 0) {
									key3 = key3 + ch;
								} else if (ch != ' ' && jmlspasi%2 == 1) {
									key2 = key2 + ch;
								} else if (ch == ' ' && jmlspasi%2 == 0) {
									key2 = key2 + "(";
									jmlspasi++;
								}
								i++;
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
