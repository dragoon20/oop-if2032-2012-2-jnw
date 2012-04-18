/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package KamusDewa;


import java.util.*;
import java.io.*;

/**
 * Kelas view dari kamus ver 1
 * @author Jordan, Adriel, and Wilson
 */
public class viewkamus {
    /**
     * constructor kelas
     */
    public viewkamus()
    {
    }

    public int printpilihan (Scanner in)
    {
        if (in!=null)
        {
            int i =-1;
            try
            {
                    System.out.println("\n+------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                                                          +");
                    System.out.println("+ *** Pilihan Struktur Data ***                                                            +");
                    System.out.println("+ 1. Map                                                                                   +");
                    System.out.println("+ 2. Tree                                                                                  +");
                    System.out.println("+                                                                                          +");
                    System.out.println("+ Untuk memilih perintah, masukkan angka yang ada di menu                                  +");
                    System.out.println("+ Selamat menggunakan!                                                                     +");
                    System.out.println("+------------------------------------------------------------------------------------------+");
                    System.out.print("\nPilihan = ");
                    i = in.nextInt();
            }	
            catch (Exception e)
            {
                    System.err.println("Error: "+e.getMessage());
            }
            finally
            {
                    return i;
            }
        }
        return -1;
    }
    
    /**
     * fungsi untuk menampilkan pilihan menu dan mengembalikan masukan integer yang dipilih user
     * @param in Scanner
     * @return menu yang dipilih user
     */
    public int printmenu (Scanner in)
    {
        if (in!=null)
        {
            int i = 7;
            try
            {
                    System.out.println("\n+------------------------------------------------------------------------------------------+");
                    System.out.println("+                                                                                          +");
                    System.out.println("+ *** Menu Utama ***                                                                       +");
                    System.out.println("+ 1. Memasukkan entry baru                                                                 +");
                    System.out.println("+ 2. Memilih kamus                                                                         +");
                    System.out.println("+ 3. Menerjemahkan kata                                                                    +");
                    System.out.println("+ 4. Mengenali bahasa masukan                                                              +");
                    System.out.println("+ 5. Menampilkan semua entri, urut abjad                                                   +");
                    System.out.println("+ 6. Menampilkan struktur internal yang dipakai                                            +");
                    System.out.println("+ 7. Quit                                                                                  +");
                    System.out.println("+                                                                                          +");
                    System.out.println("+ Untuk memilih perintah, masukkan angka yang ada di menu                                  +");
                    System.out.println("+ Selamat menggunakan!                                                                     +");
                    System.out.println("+------------------------------------------------------------------------------------------+");
                    System.out.print("\nPilihan = ");
                    i = in.nextInt();
            }	
            catch (Exception e)
            {
                    System.err.println("Error: "+e.getMessage());
            }
            finally
            {
                    return i;
            }
        }
        return 7;
    }
    
    public int printpilihanbahasa (Scanner in, String [] bahasa, String bahasadef, int jumlah)
    {
        if (in!=null)
        {
            int i = 0;
            System.out.println("\nPilihan kamus bahasa:");
            int tempint = 0;
            for (int j=0;j<jumlah;j++)
            {
                if (!bahasadef.equals(bahasa[j]))
                {
                    i++;
                    String [] temp = bahasa[j].split(" ");
                    System.out.println(i+". "+temp[0]+" -> "+temp[1]);
                }
                else
                {
                    tempint = j+1;
                }
            }
            System.out.print("Pilihan = ");
            int hasil = in.nextInt();
            if (hasil>=tempint)
            {
                hasil+=1;
            }
            hasil--;
            return hasil;
        }
        return -1;
    }

    public void printbahasadef (String bahasadef)
    {
        String [] temp = bahasadef.split(" ");
        if (bahasadef.contains(" "))
            System.out.println("\nKamus saat ini : "+temp[0]+" -> "+temp[1]);      
    }
    
    
    /**
     * prosedur untuk menge-print petunjuk cara menggunakan kamus
     */
    public void printpetunjuk ()
    // I.S. sembarang
    // F.S. dituliskan menu untuk penggunaan program pada layar
    {
            System.out.println("\n+------------------------------------------------------------------------------------------+");
            System.out.println("+ *** Cara menggunakan kamus ***                                                           +");
            System.out.println("+                                                                                          +");
            System.out.println("+ Ketikkan kata yang ingin dicari terjemahannya, lalu tekan enter                          +");
            System.out.println("+ Program akan otomatis mencari terjemahan kata tersebut, baik dalam bahasa Inggris maupun +");
            System.out.println("+ dalam bahasa Indonesia                                                                   +");
            System.out.println("+ Jika kata tidak ditemukan, maka akan muncul tulisan 'Kata tidak ada dalam database!'     +");
            System.out.println("+                                                                                          +");
            System.out.println("+ Selamat menggunakan!                                                                     +");
            System.out.println("+------------------------------------------------------------------------------------------+\n");
    }

    /**
     * prosedur untuk mencetak string tanpa newline
     * @param s string yang ingin dicetak
     */
    public void cetak (String s)
    {
            System.out.print(s);
    }

    /**
     * prosedur untuk mencetak string dengan newline
     * @param s string yang ingin dicetak
     */
    public void cetakln (String s)
    {
            System.out.println(s);
    }

    /**
     * fungsi untuk membaca masukan sebuah line
     * @param in BufferedReader untuk input
     * @return string hasil pembacaan
     */
    public String getline (BufferedReader in)
    {
        if (in!=null)
        {
            String s = "";
            try
            {
                    s = in.readLine();
            }
            catch (Exception e)
            {
                    System.err.println("Error: "+e.getMessage());
            }
            finally
            {
                    return s;
            }
        }
        return "";
    }
}
