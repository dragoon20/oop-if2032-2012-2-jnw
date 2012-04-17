/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

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
public class viewkamusTest {
    
    public viewkamusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of printpilihan method, of class viewkamus.
     */
    @Test
    public void testPrintpilihan() {
        System.out.println("printpilihan");
        Scanner in = null;
        viewkamus instance = new viewkamus();
        int expResult = -1;
        int result = instance.printpilihan(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printmenu method, of class viewkamus.
     */
    @Test
    public void testPrintmenu() {
        System.out.println("printmenu");
        Scanner in = null;
        viewkamus instance = new viewkamus();
        int expResult = 7;
        int result = instance.printmenu(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printpetunjuk method, of class viewkamus.
     */
    @Test
    public void testPrintpetunjuk() {
        System.out.println("printpetunjuk");
        viewkamus instance = new viewkamus();
        instance.printpetunjuk();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cetak method, of class viewkamus.
     */
    @Test
    public void testCetak() {
        System.out.println("cetak");
        String s = "";
        viewkamus instance = new viewkamus();
        instance.cetak(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cetakln method, of class viewkamus.
     */
    @Test
    public void testCetakln() {
        System.out.println("cetakln");
        String s = "";
        viewkamus instance = new viewkamus();
        instance.cetakln(s);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getline method, of class viewkamus.
     */
    @Test
    public void testGetline() {
        System.out.println("getline");
        BufferedReader in = null;
        viewkamus instance = new viewkamus();
        String expResult = "";
        String result = instance.getline(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
