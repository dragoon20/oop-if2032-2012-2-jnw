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
public class modellistTest {
    
    public modellistTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of readinput method, of class modellist.
     */
    @Test
    public void testReadinput() {
        System.out.println("readinput");
        String bahasa1 = "";
        String bahasa2 = "";
        String namafile = "";
        modellist instance = new modellist();
        instance.readinput(bahasa1, bahasa2, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tambahterjemahan method, of class modellist.
     */
    @Test
    public void testTambahterjemahan() {
        System.out.println("tambahterjemahan");
        String Bahasa1 = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        modellist instance = new modellist();
        int expResult = -1;
        int result = instance.tambahterjemahan(Bahasa1, s1, s2, s3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getterjemahan method, of class modellist.
     */
    @Test
    public void testGetterjemahan() {
        System.out.println("getterjemahan");
        String Bahasa = "";
        String s = "";
        modellist instance = new modellist();
        Vector expResult = new Vector();
        Vector result = instance.getterjemahan(Bahasa, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gettipe method, of class modellist.
     */
    @Test
    public void testGettipe() {
        System.out.println("gettipe");
        String b = "";
        String s = "";
        modellist instance = new modellist();
        Vector expResult = new Vector();
        Vector result = instance.gettipe(b, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of detectbahasa method, of class modellist.
     */
    @Test
    public void testDetectbahasa() {
        System.out.println("detectbahasa");
        String s = "";
        modellist instance = new modellist();
        Vector expResult = new Vector();
        Vector result = instance.detectbahasa(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cetakterurut method, of class modellist.
     */
    @Test
    public void testCetakterurut() {
        System.out.println("cetakterurut");
        String Bahasa = "";
        modellist instance = new modellist();
        instance.cetakterurut(Bahasa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeoutput method, of class modellist.
     */
    @Test
    public void testWriteoutput() {
        System.out.println("writeoutput");
        String Bahasa = "";
        String namafile = "";
        modellist instance = new modellist();
        instance.writeoutput(Bahasa, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
