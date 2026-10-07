package deque;
import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author G.J. Hu
 * @version 2025.08.06
 */
public class Lab07DequeTest extends TestCase
{

    private Lab07Deque<String> deque;

    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        deque = new Lab07Deque<String>();
    }
    
    /**
     * Tests that the isEmpty() method returns the expected output
     */  
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        
        deque.addToFront("A");
        assertFalse(deque.isEmpty());
        
        deque.removeFront();
        assertTrue(deque.isEmpty());
        
    }
    
    /**
     * Tests that the getFront() method returns the expected output
     */  
    public void testGetFront() {
        Lab07Deque<String> deque1 = new Lab07Deque<String>();
        Exception thrown = null; 
        try  
        { 
            deque1.getFront();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        } 
         
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyQueueException);
        
        deque1.addToFront("B");
        assertEquals("B", deque1.getFront());
        
        assertFalse(deque1.isEmpty());
        
        deque1.addToFront("C");
        assertEquals("C", deque1.getFront());
        
        assertEquals("C", deque1.getFront());
        
    }
    
    /**
     * Tests that the getBack() method returns the expected output
     */  
    public void testGetBack() {
        Lab07Deque<String> deque2 = new Lab07Deque<String>();
        Exception thrown = null; 
        try  
        { 
            deque2.getBack();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        } 
         
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyQueueException);
        
        deque2.addToBack("D");
        assertEquals("D", deque2.getBack());
        
        assertFalse(deque2.isEmpty());
        
        deque2.addToBack("E");
        deque2.addToBack("G");
        deque2.addToBack("F");
        assertEquals("F", deque2.getBack());
        
        deque2.removeBack();
        assertEquals("G", deque2.getBack());
        
        deque2.removeFront();
        deque2.removeBack();
        assertEquals("E", deque2.getBack());
        
       
        
        
    }
    
    /**
     * Tests that the addToFront() method returns the expected output
     */  
    public void testAddToFront() {
        Lab07Deque<String> deque3 = new Lab07Deque<String>();
        
        assertTrue(deque3.isEmpty());
        
        deque3.addToFront("A");
        assertFalse(deque3.isEmpty());
        assertEquals("A", deque3.getFront());
        assertEquals(1, deque3.size());
        
        deque3.addToFront("F");
        assertEquals("F", deque3.getFront());
        assertEquals(2, deque3.size());
        
        Lab07Deque<String> deque4 = new Lab07Deque<String>();
        
        deque4.addToFront(null);  
        assertNull(deque4.getFront());         
        assertNull(deque4.getBack());          
        assertEquals(1, deque4.size());
        assertFalse(deque4.isEmpty());
        
        deque4.addToFront("G");  
        assertEquals("G", deque4.getFront());  
        assertNull(deque4.getBack());          
        assertEquals(2, deque4.size());
        
    }
    
    /**
     * Tests that the addToBack() method returns the expected output
     */  
    public void testAddToBack() {
        Lab07Deque<String> deque7 = new Lab07Deque<String>();
        
        assertTrue(deque7.isEmpty());
        
        deque7.addToBack("A");
        assertFalse(deque7.isEmpty());
        assertEquals("A", deque7.getBack());
        assertEquals(1, deque7.size());
        
        deque7.addToBack("F");
        assertEquals("F", deque7.getBack());
        assertEquals(2, deque7.size());
        
        Lab07Deque<String> deque8 = new Lab07Deque<String>();
        
        deque8.addToBack(null);
        assertNull(deque8.getBack());
        assertNull(deque8.getFront());
        assertEquals(1, deque8.size());
        assertFalse(deque8.isEmpty());
        
        deque8.addToBack("H");
        assertEquals("H", deque8.getBack());
        assertNull(deque8.getFront());
        assertEquals(2, deque8.size());
        
        
    }
    
    /**
     * Tests that the removeFront() method returns the expected output
     */  
    public void testRemoveFront() {
        Lab07Deque<String> deque9 = new Lab07Deque<String>();
        Exception thrown = null; 
        try  
        { 
            deque9.removeFront();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        } 
        
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyQueueException);
        
        deque9.addToFront("A");
        assertEquals("A", deque9.removeFront());
        assertEquals("[]", deque9.toString());
        
        deque9.addToFront("B");
        deque9.addToFront("C"); 
        deque9.addToBack("D");
        
        assertEquals("C", deque9.removeFront()); 
        assertEquals("B", deque9.removeFront()); 
        assertEquals("D", deque9.removeFront());
        
    }
    
    /**
     * Tests that the removeBack() method returns the expected output
     */  
    public void testRemoveBack() {
        Lab07Deque<String> deque10 = new Lab07Deque<String>();
        Exception thrown = null; 
        try  
        { 
            deque10.removeBack();
        }  
        catch (Exception exception)  
        { 
            thrown = exception; 
        }
        
        assertNotNull(thrown); 
        assertTrue(thrown instanceof EmptyQueueException);
        
        deque10.addToBack("Y");
        assertEquals("Y", deque10.removeBack());
        assertEquals("[]", deque10.toString());
        
        deque10.addToFront("A");
        deque10.addToBack("B");
        deque10.addToBack("C");
        deque10.addToFront("D");
        
        assertEquals("C", deque10.removeBack());
        assertEquals("B", deque10.removeBack());
        assertEquals("A", deque10.removeBack());
        assertEquals("D", deque10.removeBack());
    }
    
    /**
     * Tests that the clear() method returns the expected output
     */  
    public void testClear() {
        Lab07Deque<String> deque5 = new Lab07Deque<String>();
        
        deque5.addToFront("A");
        deque5.addToFront("B");
        deque5.addToFront("C");

        assertFalse(deque5.isEmpty());
        assertEquals(3, deque5.size());
        
        deque5.clear();
        
        assertTrue(deque5.isEmpty());
        assertEquals(0, deque5.size());
    }
    
    /**
     * Tests that the toString() method returns the expected output
     */  
    public void testToString() {
        Lab07Deque<String> deque6 = new Lab07Deque<String>();
        assertEquals("[]", deque6.toString());
        
        deque6.addToFront("U");
        assertEquals("[U]", deque6.toString());
        
        deque6.addToBack("B");
        deque6.addToBack("C");
        assertEquals("[U, B, C]", deque6.toString());
        
        deque6.addToFront("A");
        deque6.addToBack("D");
        deque6.addToFront("E");
        deque6.addToBack("F");
        assertEquals("[E, A, U, B, C, D, F]", deque6.toString());
        
    }

}
