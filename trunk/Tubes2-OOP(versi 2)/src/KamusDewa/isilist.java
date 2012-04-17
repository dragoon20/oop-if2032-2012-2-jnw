/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author Jordan
 */
public class isilist extends LinkedList<isilist> {
    private Vector<String> isi = new Vector<String>();
    private Vector<String> tipe = new Vector<String>();
    private isilist [] huruf = new isilist[30];
    private boolean [] cekhuruf = new boolean [30];
    
    public isilist ()
    {
        for (int i=0;i<30;i++)
        {
            cekhuruf[i]=false;
        }
    }
    
    public isilist (int j)
    {
        for (int i=0;i<30;i++)
        {
            cekhuruf[i]=false;
        }
    }
    
    public void tambah (String s1, String s2, String s3)
    {
        isilist iter=this;
        for (int i=0;i<s1.length();++i)
        {
            char temp = s1.charAt(i);
            int tempint;
            if (temp=='\'')
                tempint = 26;
            else if (temp=='-')
                tempint = 27;
            else
                tempint = ((int)temp)-97;
            if (!iter.getcek(tempint))
            {
                iter.bikinlist(tempint);
                iter.setcek(tempint);
            }
            iter = iter.gethuruf(tempint);
        }
        Vector<String> temp;
        
        temp = iter.getvect();
        temp.add(s2);
        iter.setvect(temp);
        
        temp = iter.gettipe();
        temp.add(s3);
        iter.settipe(temp);
    }
    
    public Vector<String> cariarti (String s)
    {
        isilist iter=this;
        for (int i=0;i<s.length();++i)
        {
            char temp = s.charAt(i);
            int tempint;
            if (temp=='\'')
                tempint = 26;
            else if (temp=='-')
                tempint = 27;
            else
                tempint = ((int)temp)-97;
            if (!iter.getcek(tempint))
            {
                return null;
            }
            else
            {
                iter = iter.gethuruf(tempint);
            }
        }
        return iter.getvect();
    }
    
    public Vector<String> caritipe (String s)
    {
        isilist iter=this;
        for (int i=0;i<s.length();++i)
        {
            char temp = s.charAt(i);
            int tempint;
            if (temp=='\'')
                tempint = 26;
            else if (temp=='-')
                tempint = 27;
            else
                tempint = ((int)temp)-97;
            if (!iter.getcek(tempint))
            {
                return null;
            }
            else
            {
                iter = iter.gethuruf(tempint);
            }
        }
        return iter.gettipe();
    }
    
    public String tampilterurut (String s)
    {
        isilist iter = this;
        String awal = s;
        String hasil = "";
        Vector<String> temp = iter.getvect();
        Vector<String> temp2 = iter.gettipe();
        for (int i=0;i<temp.size();++i)
        {
            hasil = hasil + s+" : "+temp.get(i)+" ("+temp2.get(i) +")\n";
        }
        for (int i=0;i<30;++i)
        {
            if (iter.getcek(i))
            {
                if (i==26)
                    s=awal+"\'";
                else if (i==27)
                    s=awal+"-";
                else
                    s=awal+(char)(i+97);
                iter = iter.gethuruf(i);
                hasil = hasil+iter.tampilterurut(s);
            }
            iter = this;
        }
        return hasil;
    }
    
    public String tampilsimpan (String s)
    {
        isilist iter = this;
        String awal = s;
        String hasil = "";
        Vector<String> temp = iter.getvect();
        Vector<String> temp2 = iter.gettipe();
        for (int i=0;i<temp.size();++i)
        {
            hasil = hasil+s+"("+temp2.get(i) +")"+":"+temp.get(i)+".\n";
        }
        for (int i=0;i<30;++i)
        {
            if (iter.getcek(i))
            {
                if (i==26)
                    s=awal+"\'";
                else if (i==27)
                    s=awal+"-";
                else
                    s=awal+(char)(i+97);
                iter = iter.gethuruf(i);
                hasil = hasil+iter.tampilsimpan(s);
            }
            iter = this;
        }
        return hasil;
    }
    
    public isilist gethuruf (int i)
    {
        return huruf[i];
    }
    
    public boolean getcek (int i)
    {
        return cekhuruf[i];
    }   
    
    public void setcek (int i)
    {
        cekhuruf[i]=true;
    }
    
    public void bikinlist (int i)
    {
        huruf[i] = new isilist();
    }
    
    public void tambaharti (String s)
    {
        isi.add(s);
    }
    
    public Vector<String> getvect ()
    {
        return isi;
    }
    
    public void setvect (Vector<String> v)
    {
        isi = v;
    }
    
    public Vector<String> gettipe ()
    {
        return tipe;
    }
    
    public void settipe (Vector<String> v)
    {
        tipe = v;
    }
}
