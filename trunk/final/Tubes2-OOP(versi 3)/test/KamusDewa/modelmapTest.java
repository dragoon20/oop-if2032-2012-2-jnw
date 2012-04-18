/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KamusDewa;

import java.util.SortedMap;
import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class modelmapTest {
    
    public modelmapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of cetakterurut method, of class modelmap.
     */
    @Test
    public void testCetakterurut() {
        System.out.println("cetakterurut");
        String Bahasa = "";
        modelmap instance = new modelmap();
        instance.cetakterurut(Bahasa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of detectbahasa method, of class modelmap.
     */
    @Test
    public void testDetectbahasa() {
        System.out.println("detectbahasa");
        String s = "";
        modelmap instance = new modelmap();
        Vector expResult = new Vector();
        Vector result = instance.detectbahasa(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gettipe method, of class modelmap.
     */
    @Test
    public void testGettipe() {
        System.out.println("gettipe");
        String bhs = "";
        String s = "";
        modelmap instance = new modelmap();
        Vector expResult = new Vector();
        Vector result = instance.gettipe(bhs, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getterjemahan method, of class modelmap.
     */
    @Test
    public void testGetterjemahan() {
        System.out.println("getterjemahan");
        String Bahasa = "";
        String s = "";
        modelmap instance = new modelmap();
        Vector expResult = new Vector();
        Vector result = instance.getterjemahan(Bahasa, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tambahterjemahan method, of class modelmap.
     */
    @Test
    public void testTambahterjemahan() {
        System.out.println("tambahterjemahan");
        String Bahasa1 = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        modelmap instance = new modelmap();
        int expResult = -1;
        int result = instance.tambahterjemahan(Bahasa1, s1, s2, s3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getmap method, of class modelmap.
     */
    @Test
    public void testGetmap() {
        System.out.println("getmap");
        int i = 0;
        modelmap instance = new modelmap();
        SortedMap expResult = null;
        SortedMap result = instance.getmap(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setmap method, of class modelmap.
     */
    @Test
    public void testSetmap() {
        System.out.println("setmap");
        SortedMap<String, String> m = null;
        int i = 0;
        modelmap instance = new modelmap();
        instance.setmap(m, i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readinput method, of class modelmap.
     */
    @Test
    public void testReadinput() {
        System.out.println("readinput");
        String bahasa1 = "";
        String bahasa2 = "";
        String namafile = "";
        modelmap instance = new modelmap();
        instance.readinput(bahasa1, bahasa2, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeoutput method, of class modelmap.
     */
    @Test
    public void testWriteoutput() {
        System.out.println("writeoutput");
        String Bahasa = "";
        String namafile = "";
        modelmap instance = new modelmap();
        instance.writeoutput(Bahasa, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
