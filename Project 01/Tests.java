import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

//    @Test
//    public void testAdd() {
//        LinkedList num1 = new LinkedList(new Node(7, new Node(5, null)));
//        LinkedList num2 = new LinkedList(new Node(3, new Node(2, null)));
//        LinkedList result = Operations.add(num1, num2);
//        assertEquals("80", result.toString());
//    }
    @Test
    public void testMultiply() {
        // Test case 1: 12 * 34
        LinkedList num1 = new LinkedList(new Node(2, new Node(1, null)));
        LinkedList num2 = new LinkedList(new Node(4, new Node(3, null)));
        LinkedList result = Operations.multiply(num1, num2);
        assertEquals("4 0 6 8", result.toString());

        // Test case 2: 999 * 0 (should result in 0)
        num1 = new LinkedList(new Node(9, new Node(9, new Node(9, null))));
        num2 = new LinkedList(new Node(0, null));
        result = Operations.multiply(num1, num2);
        assertEquals("0", result.toString());
    }

        @Test
        public void testAdd() {
            LinkedList list = new LinkedList(null);
            list.add(5);
            list.add(7);
            assertEquals("75", list.toString());
        }

        @Test
        public void testGetLength() {
            LinkedList list = new LinkedList(null);
            assertEquals(0, list.getLength());

            list.add(5);
            assertEquals(1, list.getLength());

            list.add(7);
            list.add(3);
            assertEquals(3, list.getLength());
        }

        @Test
        public void testToString() {
            LinkedList list = new LinkedList(null);
            assertEquals("0", list.toString());

            list.add(1);
            list.add(2);
            list.add(3);
            assertEquals("321", list.toString());
        }

        @Test
        public void testReverse() {
            LinkedList list = new LinkedList(null);
            list.reverse();
            assertEquals("0", list.toString());

            list.add(1);
            list.reverse();
            assertEquals("1", list.toString());

            list.add(2);
            list.add(3);
            list.reverse();
            assertEquals("321", list.toString());
        }
    }

