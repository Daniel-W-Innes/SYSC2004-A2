import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Schramm
 */
public class SnakeSquareTest {
    
    public SnakeSquareTest() {
    }

    /**
     * Test of getNumber method, of class SnakeSquare.
     */
    @Test
    public void testGetNumber() {
        SnakeSquare instance = new SnakeSquare(33,22);
        assertEquals(33, instance.getNumber());
        assertEquals(22, instance.getEndSquare());
        
    }

     /**
     * Test of Constructor's: IllegalArgumentException.
     */
    @Test
    public void testBadConstructor() {
        try {
            @SuppressWarnings("unused")
			SnakeSquare instance = new SnakeSquare(33,44);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    /**
     * Test of toString()
     */
    @Test
    public void testToString() {
        SnakeSquare instance = new SnakeSquare(33,21);
        assertEquals("33-21", instance.toString());
    }

    /**
     * Test of landOn method, of class SnakeSquare.
     */
    @Test
    public void testLandOn() {
       SnakeSquare instance = new SnakeSquare(33, 21);
       assertEquals(21, instance.landOn());
    }

    /**
     * Test of equals method, of class SnakeSquare.
     */
    @Test
    public void testEqualsNull() {
        SnakeSquare instance = new SnakeSquare(33, 21);
        try {
            assertEquals(false, instance.equals(null));
        } catch (NullPointerException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsThis() {
        SnakeSquare instance = new SnakeSquare(33,21);
        assertEquals(true, instance.equals(instance));
    }
    @Test
    public void testEqualsClassCast() {
        SnakeSquare instance = new SnakeSquare(33, 21);
        SorLSquare other = new SorLSquare(33,21);
        try {
            assertEquals(false, instance.equals(other));
            assertEquals(false, other.equals(instance));
        } catch (ClassCastException e) { 
            fail();
        }
    }
    @Test
    public void testEqualsTrue() {
        SnakeSquare instance = new SnakeSquare(33, 12);
        SnakeSquare other = new SnakeSquare(33, 12);
        assertEquals(true, instance.equals(other));
    }
    @Test
    public void testEqualsFalse() {
        SnakeSquare instance = new SnakeSquare(33, 12);
        SnakeSquare other = new SnakeSquare(34, 12);
        assertEquals(false, instance.equals(other));
    }
    
}
