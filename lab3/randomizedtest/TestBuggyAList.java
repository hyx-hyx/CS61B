package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    public void testThreeAddThreeRemove() {

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> testedList=new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                testedList.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int testedsize=testedList.size();
                assertEquals("size is not equal",size,testedsize);
                System.out.println("size: " + size);
                System.out.println("testedsize: " + testedsize);
            } else if (operationNumber == 2) {
                //assertTrue("BuggyAList size <0 ",testedList.size()>0);
                if (L.size() > 0) {
                    int last=L.getLast();
                    int testedlast=testedList.getLast();
                    assertEquals("lastval is not equal",last,testedlast);
                    //System.out.println("getLast: "+L.getLast());
                }
            } else if (operationNumber == 3) {
                //assertTrue("BuggyAList size <0 ",testedList.size()>0);
                if (L.size() > 0) {
                    L.removeLast();
                    testedList.removeLast();
                }
            }
        }
    }
}
