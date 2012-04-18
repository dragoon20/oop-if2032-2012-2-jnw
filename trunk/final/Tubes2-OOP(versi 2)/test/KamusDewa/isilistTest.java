/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class isilistTest {
    
    public isilistTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of tambah method, of class isilist.
     */
    @Test
    public void testTambah() {
        System.out.println("tambah");
        String s1 = "";
        String s2 = "";
        String s3 = "";
        isilist instance = new isilist();
        instance.tambah(s1, s2, s3);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cariarti method, of class isilist.
     */
    @Test
    public void testCariarti() {
        System.out.println("cariarti");
        String s = "";
        isilist instance = new isilist();
        Vector expResult = new Vector();
        Vector result = instance.cariarti(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of caritipe method, of class isilist.
     */
    @Test
    public void testCaritipe() {
        System.out.println("caritipe");
        String s = "";
        isilist instance = new isilist();
        Vector expResult = new Vector();
        Vector result = instance.caritipe(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tampilterurut method, of class isilist.
     */
    @Test
    public void testTampilterurut() {
        System.out.println("tampilterurut");
        String s = "";
        isilist instance = new isilist();
        String expResult = "";
        String result = instance.tampilterurut(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tampilsimpan method, of class isilist.
     */
    @Test
    public void testTampilsimpan() {
        System.out.println("tampilsimpan");
        String s = "";
        isilist instance = new isilist();
        String expResult = "";
        String result = instance.tampilsimpan(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gethuruf method, of class isilist.
     */
    @Test
    public void testGethuruf() {
        System.out.println("gethuruf");
        int i = 0;
        isilist instance = new isilist();
        isilist expResult = null;
        isilist result = instance.gethuruf(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getcek method, of class isilist.
     */
    @Test
    public void testGetcek() {
        System.out.println("getcek");
        int i = 0;
        isilist instance = new isilist();
        boolean expResult = false;
        boolean result = instance.getcek(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setcek method, of class isilist.
     */
    @Test
    public void testSetcek() {
        System.out.println("setcek");
        int i = 0;
        isilist instance = new isilist();
        instance.setcek(i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of bikinlist method, of class isilist.
     */
    @Test
    public void testBikinlist() {
        System.out.println("bikinlist");
        int i = 0;
        isilist instance = new isilist();
        instance.bikinlist(i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tambaharti method, of class isilist.
     */
    @Test
    public void testTambaharti() {
        System.out.println("tambaharti");
        String s = "";
        isilist instance = new isilist();
        instance.tambaharti(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getvect method, of class isilist.
     */
    @Test
    public void testGetvect() {
        System.out.println("getvect");
        isilist instance = new isilist();
        Vector expResult = new Vector();
        Vector result = instance.getvect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setvect method, of class isilist.
     */
    @Test
    public void testSetvect() {
        System.out.println("setvect");
        Vector<String> v = null;
        isilist instance = new isilist();
        instance.setvect(v);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gettipe method, of class isilist.
     */
    @Test
    public void testGettipe() {
        System.out.println("gettipe");
        isilist instance = new isilist();
        Vector expResult = new Vector();
        Vector result = instance.gettipe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of settipe method, of class isilist.
     */
    @Test
    public void testSettipe() {
        System.out.println("settipe");
        Vector<String> v = null;
        isilist instance = new isilist();
        instance.settipe(v);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
