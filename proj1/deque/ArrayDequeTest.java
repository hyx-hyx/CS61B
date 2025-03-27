package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Performs some basic linked list tests.
 */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void iteratorTest() {
        Deque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 16; ++i) {
            ad1.addFirst(i);
            System.out.print(ad1);
        }
        System.out.println();
        System.out.println(ad1);
    }

    @Test
    public void equalBasicTrueTest() {
        Boolean expect_result = true;
        Deque<Integer> ad1 = new ArrayDeque<>();
        Deque<Integer> lld2 = new LinkedListDeque<>();

        assertEquals(expect_result, lld2.equals(ad1));
        assertEquals(expect_result, ad1.equals(lld2));

        for (int i = 0; i < 16; ++i) {
            ad1.addFirst(i);
            lld2.addFirst(i);
            assertEquals(expect_result, lld2.equals(ad1));
            assertEquals(expect_result, ad1.equals(lld2));
        }
        System.out.println(ad1);
        System.out.println(lld2);
        while (ad1.size() > 0) {
            ad1.removeFirst();
            lld2.removeFirst();
            assertEquals(expect_result, lld2.equals(ad1));
            assertEquals(expect_result, ad1.equals(lld2));
        }
    }

    @Test
    public void equalRefTrueTest() {
        Boolean expect_result = true;

        Deque<Integer> ad1 = new ArrayDeque<Integer>();
        Deque<Integer> lld1 = new LinkedListDeque<Integer>();

        Deque<Deque> ad2 = new ArrayDeque<Deque>();
        Deque<Deque> lld2 = new LinkedListDeque<Deque>();

        ad2.addFirst(lld1);
        lld2.addLast(ad1);

        assertEquals(expect_result, lld2.equals(ad2));
        assertEquals(expect_result, ad2.equals(lld2));


    }

    @Test
    public void equalFalseTest() {
        Boolean expect_result = false;
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        ad1.addFirst(1);
        ad1.removeFirst();
        lld2.addFirst(2);
        assertEquals(expect_result, lld2.equals(ad1));
    }


    @Test
    public void equalTest() {
        Deque<Integer> ad1 = new ArrayDeque<>();
        Deque<Integer> lld1 = new LinkedListDeque<>();
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.removeFirst();
        lld1.addFirst(2);

        java.util.Deque<Integer> ad2 = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> lld2 = new java.util.ArrayDeque<>();
        ad2.addFirst(1);
        ad2.addLast(2);
        ad2.removeFirst();
        lld2.addFirst(2);
        lld2.equals(ad2);

        assertEquals(lld2.equals(ad2), lld1.equals(ad1));
    }

    @Test
    public void emptyTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 12; ++i) {
            lld1.addFirst(i);
        }
        while (!lld1.isEmpty()) {
            lld1.removeFirst();
        }
        Integer i1 = lld1.get(3);
        assertEquals(null, i1);
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 22; ++i) {
            if (i % 2 == 0) {
                lld1.addFirst(i);
            } else {
                lld1.addLast(i);
            }
        }
        while (!lld1.isEmpty()) {
            lld1.removeFirst();
        }
        assertEquals(null, lld1.get(3));
    }
}
