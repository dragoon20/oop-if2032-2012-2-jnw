//modelmapone.java

import java.util.*;
import java.io.*;
import java.io.Console;

class modelmapone
{
	private SortedMap map[];
	private int jumlah;
	private SortedMap bahasa = new TreeMap();
	private String [] namabahasa;
	private SortedMap tipe = new TreeMap();
	
	public modelmapone (int Jumlah, String [] Bahasa)
	{
		jumlah=Jumlah;
		map = new SortedMap[jumlah];
		for (int i=0;i<jumlah;++i)
		{
			map[i] = new TreeMap();
		}
		int i = 0;
		for (String s : Bahasa)
		{
			bahasa.put(s,i);
			i++;
		}
		namabahasa = new String[i];
		i = 0;
		for (String s : Bahasa)
		{
			namabahasa[i]=s;
			i++;
		}
	}
	
	public void cetakmap (int i)
	{
		viewmapone view = new viewmapone();
		Iterator iterator = map[i].keySet().iterator();
		while (iterator.hasNext()) 
		{
			Object key = iterator.next();
			view.cetakln(key + " : " + map[i].get(key) + " (" + tipe.get(key) + ")");
		}
	}
	
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
		return value;
	}
	
	public String getterjemahan (int Bahasa, String s)
	{
		if (map[Bahasa].get(s)!=null)
			return (String) map[Bahasa].get(s);
		return "";
	}
	
	public String gettipe (String s)
	{
		return (String) tipe.get(s);
	}
	
	public SortedMap getmap (int i)
	{
		return map[i];
	}
	
	public int tambahterjemahan (int Bahasa1, int Bahasa2, String s1, String s2, String s3)
	{
		boolean cek = false;
		if (map[Bahasa1].get(s1)==null)
		{
			map[Bahasa1].put(s1,s2);
			tipe.put(s1,s3);
			cek = true;
		}
		if (map[Bahasa2].get(s2)==null)
		{
			map[Bahasa2].put(s2,s1);
			tipe.put(s2,s3);
			cek = true;
		}
		if (cek)
			return 0;
		return -1;
	}
	
	public void setmap (SortedMap m, int i)
	{
		Iterator iterator = m.keySet().iterator();
		while (iterator.hasNext()) 
		{
			Object key = iterator.next();
			if (map[i].get(key)==null)
				map[i].put(key,m.get(key));
		}
	}
	
	public void readinput (String bahasa1, String bahasa2, String namafile)
	{
		try
		{
			int bhs1 = (int)bahasa.get(bahasa1);
			int bhs2 = (int)bahasa.get(bahasa2);
			
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
					if (map[bhs1].get(s1)==null)
					{
						map[bhs1].put(s1,s2);
						tipe.put(s1,s3);
					}
					if (map[bhs2].get(s2)==null)
					{
						map[bhs2].put(s2,s1);
						tipe.put(s2,s3);
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
			System.err.println("Error: "+e.getMessage());
		}
	}
	
	public void writeoutput (String Bahasa, String namafile)
	{
		try
		{
			int bhs = (int)bahasa.get(Bahasa);
			// Create file 
			FileWriter fstream = new FileWriter(namafile);
			BufferedWriter out = new BufferedWriter(fstream);

			Iterator iterator = map[bhs].keySet().iterator();
			while (iterator.hasNext()) 
			{
				Object key = iterator.next();
				out.write(key + "(" + tipe.get(key) + "):" + map[bhs].get(key) + ".\n");
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