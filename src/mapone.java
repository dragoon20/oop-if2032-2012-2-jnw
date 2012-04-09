//mapone.java

import java.util.*;
import java.io.*;
import java.io.Console;

class mapone
{
	public static void printmenu ()
	{
		System.out.println("");
		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("+                                                                                          +");
		System.out.println("+ *** Menu Utama ***                                                                       +");
		System.out.println("+ 1. Memasukkan entry baru                                                                 +");
		System.out.println("+ 2. Memutar arah bahasa                                                                   +");
		System.out.println("+ 3. Menerjemahkan kata                                                                    +");
		System.out.println("+ 4. Mengenali bahasa masukan                                                              +");
		System.out.println("+ 5. Menampilkan semua entri, urut abjad                                                   +");
		System.out.println("+ 6. Menampilkan struktur internal yang dipakai                                            +");
		System.out.println("+ 7. Quit                                                                                  +");
		System.out.println("+                                                                                          +");
		System.out.println("+ Untuk memilih perintah, masukkan angka yang ada di menu                                  +");
		System.out.println("+ Selamat menggunakan!                                                                     +");
		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("");
	}
	public static void printmenu1 ()
	// I.S. sembarang
	// F.S. dituliskan menu untuk penggunaan program pada layar
	{
		System.out.println("");
		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("+ *** Cara menggunakan kamus ***                                                           +");
		System.out.println("+                                                                                          +");
		System.out.println("+ Ketikkan kata yang ingin dicari terjemahannya, lalu tekan enter                          +");
		System.out.println("+ Program akan otomatis mencari terjemahan kata tersebut, baik dalam bahasa Inggris maupun +");
		System.out.println("+ dalam bahasa Indonesia                                                                   +");
		System.out.println("+ Jika kata tidak ditemukan, maka akan muncul tulisan 'Kata tidak ada dalam database!'     +");
		System.out.println("+                                                                                          +");
		System.out.println("+ Selamat menggunakan!                                                                     +");
		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("");
	}
	
	public static boolean isInd(SortedMap m, String s) 
	// mengembalikan true jika string s merupakan sebuah key dari mapind
	// yang berarti string s adalah sebuah kata dalam bahasa indonesia
	{
		if (m.get(s)!=null) 
		{
			return true ;
		}
		else
		{
			return false ;
		}
	}
	
	public static boolean isEng(SortedMap m, String s) 
	// mengembalikan true jika string s merupakan sebuah key dari maping
	// yang berarti string s adalah sebuah kata dalam bahasa inggris
	{
		if (m.get(s)!=null) 
		{
			return true ;
		}
		else
		{
			return false ;
		}
	}
	
	public static void main(String[] args)
	{
		Console console = System.console();
		SortedMap mapind = new TreeMap();
		SortedMap maping = new TreeMap();
		try
		{
			FileInputStream fstream = new FileInputStream("DicIndonesiaEnglish.txt");
			DataInputStream fin = new DataInputStream(fstream);
			BufferedReader brf = new BufferedReader(new InputStreamReader(fin));
			
			String s1="";
			String s2="";
			boolean cek = false;
			int tempint;
			String temp;
			while ((tempint=brf.read())!=-1)
			{
				temp=""+(char)tempint;
				if (temp.compareTo(":")==0)
				{
					cek = true;
					//System.out.println("1");
				}
				else if (temp.compareTo(".")==0)
				{
					cek = false;
					if (mapind.get(s1)==null)
					{
						mapind.put(s1,s2);
						//System.out.println(s1+" "+s2);
					}
					if (maping.get(s2)==null)
					{
						maping.put(s2,s1);
						//System.out.println(s1+" "+s2);
					}
				}
				else if (cek)
				{
					s2 = s2+temp;
				}
				else if (temp.compareTo("\n")!=0)
				{
					s1 = s1+temp;
				}
				else
				{
					s1="";
					s2="";
					//System.out.println("2");
				}
			}
			
			fin.close();
			
			BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
			Scanner in = new Scanner(System.in);
			int a=1;
			int i=0;

			try
			{
				Process p=Runtime.getRuntime().exec("cmd /c clear");
				p.waitFor();
			}
			catch (IOException e1) {}
			catch (InterruptedException e2) {}
			
			while (i!=7)
			{
				printmenu();
				System.out.print("Pilihan = ");
				i = in.nextInt();
				switch (i) 
				{
					case 1:	{
								
								break;
							}
							
					case 2:	{
								if (a==1)
								{
									a=2;
									System.out.println("Bahasa Indonesia -> Bahasa Inggris");
								}
								else if (a==2)
								{
									a=1;
									System.out.println("Bahasa Inggris -> Bahasa Indonesia");
								}
								break;
							}
							
					case 3: {
								printmenu1();
								System.out.print("Input Kata : ");
								String s = brin.readLine();

								if ((a==1) && (isInd(mapind, s)))
								{
									System.out.println(mapind.get(s));
								}
								else if ((a==2) && (isEng(maping, s)))
								{
										System.out.println(maping.get(s));
								}
								else
								{
									System.out.println("Kata tidak ada dalam database!");
								}
								break;
							}
							
					case 4:	{
								System.out.print("Input Kata : ");
								String s = brin.readLine();
								System.out.print("Terjemahan Kata : ");
								if (isInd(mapind, s))
								{
									System.out.println("Kata dalam Bahasa Indonesia");
								}
								else if (isEng(maping, s))
								{
									System.out.println("Kata dalam Bahasa Inggris");
								}
								else
								{
									System.out.println("Kata tidak ada dalam database");
								}
								break;
							}
							
					case 5: {	
								if (a==1)
								{
									Iterator iterator = mapind.keySet().iterator();
									while (iterator.hasNext()) 
									{
										Object key = iterator.next();
										System.out.println(key + " : " + mapind.get(key));
									}
								}
								else if (a==2)
								{
									Iterator iterator = maping.keySet().iterator();
									while (iterator.hasNext()) 
									{
										Object key = iterator.next();
										System.out.println(key + " : " + maping.get(key));
									}
								}
								
								break;
							}
							
					case 6:	{
								System.out.println("Kami menggunakan struktur data Java util Map");
								break;
							}
							
					case 7: {
								System.out.println(" *** Terima Kasih sudah menggunakan program ini ***");
								break;
							}
							
					default:{
								System.out.println("Perintah masukan salah");
								break;
							}
				}
				
			}
		}
		catch (Exception e)
		{
			System.err.println("Error: "+e.getMessage());
		}
	}
}
/*
  SortedMap map = new TreeMap();

  // Add some elements:
  map.put("2", "Two");
  map.put("1", "One");
  map.put("5", "Five");
  map.put("4", "Four");
  map.put("3", "Three");

  // Display the lowest key:
  System.out.println("The lowest key value is: " + map.firstKey());

  // Display the highest key:
  System.out.println("The highest key value is: " + map.lastKey());

  // Display All key value
  System.out.println("All key value is:\n" + map);

  // Display the headMap:
  System.out.println("The head map is:\n" + map.headMap("4"));

  // Display the tailMap:
  System.out.println("The tail map is:\n" + map.tailMap("4"));

  // keySet method returns a Set view of the keys contained in this map.
  Iterator iterator = map.keySet().iterator();
  while (iterator.hasNext()) {
  Object key = iterator.next();
  System.out.println("key : " + key + " value :" + map.get(key));
  }
  }*/