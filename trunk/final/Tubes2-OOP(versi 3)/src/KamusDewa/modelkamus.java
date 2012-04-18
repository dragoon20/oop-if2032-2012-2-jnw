/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

import java.util.*;
/**
 *
 * @author Jordan
 */
public interface modelkamus {
    /**
     * prosedur untuk mencetak entri kamus dalam map
     * @param Bahasa map bahasa yang dicetak
     */
    public abstract void cetakterurut (String Bahasa);
    
    /**
     * fungsi untuk mendeteksi ada bahasa apa saja dalam map
     * @param s Kata yang ingin dideteksi
     * @return Bahasa-bahasa yang memiliki kata tersebut
     */
    public abstract Vector<String> detectbahasa (String s);

    /**
     * getter value untuk map tipe
     * @param s kata yang ingin diketahui tipenya
     * @return tipe dari s
     */
    public abstract Vector<String> gettipe (String bhs, String s);

        /**
     * fungsi untuk memperoleh terjemahan bahasa dari bahasa yg diinginkan
     * @param Bahasa bahasa yang ingin diterjemahkan
     * @param s kata yang ingin diterjemahkan
     * @return terjemahan dari bahasa yang diingingkan
     */
    public abstract Vector<String> getterjemahan (String Bahasa, String s);
    
    /**
     * fungsi untuk mengisi entri kata dan terjemahan baru, mengembalikan 0 jika kata belum ada, mengembalikan -1 jika entri kata sudah ada
     * @param Bahasa1 bahasa pertama
     * @param Bahasa2 bahasa kedua
     * @param s1 kata pertama
     * @param s2 kata kedua
     * @param s3 tipe kata
     * @return nilai yang menandakan apakah kata berhasil dimasukkan
     */
    public abstract int tambahterjemahan (String Bahasa1, String s1, String s2, String s3);


    /**
     * prosedur untuk membaca file dari luar
     * @param bahasa1 bahasa pertama
     * @param bahasa2 bahasa kedua
     * @param namafile nama file.txt yang mengandung kamus dari bahasa1 ke bahasa2
     */
    public abstract void readinput (String bahasa1, String bahasa2, String namafile);

    /**
     * prosedur untuk menuliskan isi map sekarang ke file luar
     * @param Bahasa bahasa yang ingin ditulis
     * @param namafile nama file
     */
    public abstract void writeoutput (String Bahasa, String namafile);
}
