
package tubes2.oop;


import java.util.*;
import java.io.*;

/**
 * Kelas view dari kamus ver 1
 * @author Jordan, Adriel, and Wilson
 */
public class viewmapone {
    /**
     * constructor kelas
     */
    public viewmapone()
    {
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
                    System.out.print("Pilihan = ");
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

    
    /**
     * prosedur untuk menge-print petunjuk cara menggunakan kamus
     */
    public void printpetunjuk ()
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
