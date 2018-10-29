import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Schramm
 */
public class SnLSquareTest {
    
    public SnLSquareTest() {
    }

    /**
     * Test of getNumber method, of class SnLSquare.
     */
    @Test
    public void testGetNumber() {
        SnLSquare instance = new SnLSquare(33);
        assertEquals(33, instance.getNumber());
    }

    /**
     * Test of toString method, of class SnLSquare.
     */
    @Test
    public void testToString() {
        SnLSquare instance = new SnLSquare(33);
        assertEquals("33", instance.toString());
    }

    /**
     * Test of landOn method, of class SnLSquare.
     */
    @Test
    public void testLandOn() {
       SnLSquare instance = new SnLSquare(33);
       assertEquals(33, instance.landOn());
    }

    /**
     * Test of equals method, of class SnLSquare.
     */
    @Test
    public void testEqualsNull() {
        SnLSquare instance = new SnLSquare(33);
        try {
            assertEquals(false, instance.equals(null));
        } catch (NullPointerException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsThis() {
        SnLSquare instance = new SnLSquare(33);
        assertEquals(true, instance.equals(instance));
    }
    @Test
    public void testEqualsClassCast() {
        SnLSquare instance = new SnLSquare(33);
        Point p = new Point(3,5);
        try {
            assertEquals(false, instance.equals(p));
        } catch (ClassCastException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsTrue() {
        SnLSquare instance = new SnLSquare(33);
        SnLSquare other = new SnLSquare(33);
        assertEquals(true, instance.equals(other));
    }
    @Test
    public void testEqualsFalse() {
        SnLSquare instance = new SnLSquare(33);
        SnLSquare other = new SnLSquare(34);
        assertEquals(false, instance.equals(other));
    }
    
}
