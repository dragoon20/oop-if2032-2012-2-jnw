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
public class modelkamusTest {
    
    public modelkamusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of cetakterurut method, of class modelkamus.
     */
    @Test
    public void testCetakterurut() {
        System.out.println("cetakterurut");
        String Bahasa = "";
        modelkamus instance = new modelkamusImpl();
        instance.cetakterurut(Bahasa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of detectbahasa method, of class modelkamus.
     */
    @Test
    public void testDetectbahasa() {
        System.out.println("detectbahasa");
        String s = "";
        modelkamus instance = new modelkamusImpl();
        Vector expResult = null;
        Vector result = instance.detectbahasa(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of gettipe method, of class modelkamus.
     */
    @Test
    public void testGettipe() {
        System.out.println("gettipe");
        String bhs = "";
        String s = "";
        modelkamus instance = new modelkamusImpl();
        Vector expResult = null;
        Vector result = instance.gettipe(bhs, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getterjemahan method, of class modelkamus.
     */
    @Test
    public void testGetterjemahan() {
        System.out.println("getterjemahan");
        String Bahasa = "";
        String s = "";
        modelkamus instance = new modelkamusImpl();
        Vector expResult = null;
        Vector result = instance.getterjemahan(Bahasa, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tambahterjemahan method, of class modelkamus.
     */
    @Test
    public void testTambahterjemahan() {
        System.out.println("tambahterjemahan");
        String Bahasa1 = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        modelkamus instance = new modelkamusImpl();
        int expResult = 0;
        int result = instance.tambahterjemahan(Bahasa1, s1, s2, s3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readinput method, of class modelkamus.
     */
    @Test
    public void testReadinput() {
        System.out.println("readinput");
        String bahasa1 = "";
        String bahasa2 = "";
        String namafile = "";
        modelkamus instance = new modelkamusImpl();
        instance.readinput(bahasa1, bahasa2, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeoutput method, of class modelkamus.
     */
    @Test
    public void testWriteoutput() {
        System.out.println("writeoutput");
        String Bahasa = "";
        String namafile = "";
        modelkamus instance = new modelkamusImpl();
        instance.writeoutput(Bahasa, namafile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class modelkamusImpl implements modelkamus {

        public void cetakterurut(String Bahasa) {
        }

        public Vector<String> detectbahasa(String s) {
            return null;
        }

        public Vector<String> gettipe(String bhs, String s) {
            return null;
        }

        public Vector<String> getterjemahan(String Bahasa, String s) {
            return null;
        }

        public int tambahterjemahan(String Bahasa1, String s1, String s2, String s3) {
            return 0;
        }

        public void readinput(String bahasa1, String bahasa2, String namafile) {
        }

        public void writeoutput(String Bahasa, String namafile) {
        }
    }
}
