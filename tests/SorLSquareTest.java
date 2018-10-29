import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Schramm
 */
public class SorLSquareTest {
    
    public SorLSquareTest() {
    }

    /**
     * Test of getNumber method, of class SorLSquare.
     */
    @Test
    public void testGetNumber() {
        SorLSquare instance = new SorLSquare(33,55);
        assertEquals(33, instance.getNumber());
        assertEquals(55, instance.getEndSquare());
    }

     /**
     * Test of Constructor's: IllegalArgumentException.
     */
    @Test
    public void testBadConstructor() {
        try {
            SorLSquare instance = new SorLSquare(33,33);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    /**
     * Test of toString()
     */
    @Test
    public void testToString() {
        SorLSquare instance = new SorLSquare(33,67);
        assertEquals("33:67", instance.toString());
    }

    /**
     * Test of landOn method, of class SorLSquare.
     */
    @Test
    public void testLandOn() {
       SorLSquare instance = new SorLSquare(33, 44);
       assertEquals(44, instance.landOn());
    }

    /**
     * Test of equals method, of class SorLSquare.
     */
    @Test
    public void testEqualsNull() {
        SorLSquare instance = new SorLSquare(33, 21);
        try {
            assertEquals(false, instance.equals(null));
        } catch (NullPointerException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsThis() {
        SorLSquare instance = new SorLSquare(33,55);
        assertEquals(true, instance.equals(instance));
    }
    @Test
    public void testEqualsClassCast() {
        SorLSquare instance = new SorLSquare(33, 44);
        SnLSquare other = new SnLSquare(33);
        try {
            assertEquals(false, instance.equals(other));
            assertEquals(false, other.equals(instance));
        } catch (ClassCastException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsTrue() {
        SorLSquare instance = new SorLSquare(33, 12);
        SorLSquare other = new SorLSquare(33, 12);
        assertEquals(true, instance.equals(other));
    }
    @Test
    public void testEqualsFalse() {
        SorLSquare instance = new SorLSquare(33, 12);
        SorLSquare other = new SorLSquare(34, 12);
        assertEquals(false, instance.equals(other));
    }
    
}
