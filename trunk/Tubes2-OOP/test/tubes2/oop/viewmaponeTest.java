/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes2.oop;

import java.io.BufferedReader;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class viewmaponeTest {
    
    public viewmaponeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of printmenu method, of class viewmapone.
     */
    @Test
    public void testPrintmenu() {
        System.out.println("printmenu");
        Scanner in = null;
        viewmapone instance = new viewmapone();
        int expResult = 7;
        int result = instance.printmenu(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printpetunjuk method, of class viewmapone.
     */
    @Test
    public void testPrintpetunjuk() {
        System.out.println("printpetunjuk");
        viewmapone instance = new viewmapone();
        instance.printpetunjuk();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cetak method, of class viewmapone.
     */
    @Test
    public void testCetak() {
        System.out.println("cetak");
        String s = "";
        viewmapone instance = new viewmapone();
        instance.cetak(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cetakln method, of class viewmapone.
     */
    @Test
    public void testCetakln() {
        System.out.println("cetakln");
        String s = "";
        viewmapone instance = new viewmapone();
        instance.cetakln(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getline method, of class viewmapone.
     */
    @Test
    public void testGetline() {
        System.out.println("getline");
        BufferedReader in = null;
        viewmapone instance = new viewmapone();
        String expResult = "";
        String result = instance.getline(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
