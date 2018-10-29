import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Schramm
 */
public class LadderSquareTest {
    
    public LadderSquareTest() {
    }

    /**
     * Test of getNumber method, of class LadderSquare.
     */
    @Test
    public void testGetNumber() {
        LadderSquare instance = new LadderSquare(33,55);
        assertEquals(33, instance.getNumber());
        assertEquals(55, instance.getEndSquare());
    }

     /**
     * Test of Constructor's: IllegalArgumentException.
     */
    @Test
    public void testBadConstructor() {
        try {
            LadderSquare instance = new LadderSquare(33,12);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    /**
     * Test of toString()
     */
    @Test
    public void testToString() {
        LadderSquare instance = new LadderSquare(33,67);
        assertEquals("33+67", instance.toString());
    }

    /**
     * Test of landOn method, of class LadderSquare.
     */
    @Test
    public void testLandOn() {
       LadderSquare instance = new LadderSquare(33, 44);
       assertEquals(44, instance.landOn());
    }

    /**
     * Test of equals method, of class LadderSquare.
     */
    @Test
    public void testEqualsNull() {
        LadderSquare instance = new LadderSquare(33, 44);
        try {
            assertEquals(false, instance.equals(null));
        } catch (NullPointerException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsThis() {
        LadderSquare instance = new LadderSquare(33,55);
        assertEquals(true, instance.equals(instance));
    }
    @Test
    public void testEqualsClassCast() {
        LadderSquare instance = new LadderSquare(33, 44);
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
        LadderSquare instance = new LadderSquare(33, 44);
        LadderSquare other = new LadderSquare(33, 44);
        assertEquals(true, instance.equals(other));
    }
    @Test
    public void testEqualsFalse() {
        LadderSquare instance = new LadderSquare(33, 44);
        LadderSquare other = new LadderSquare(34, 44);
        assertEquals(false, instance.equals(other));
    }
    
}
