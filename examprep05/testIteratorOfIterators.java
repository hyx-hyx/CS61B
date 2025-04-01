import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testIteratorOfIterators {
    @Test
    public void testiter(){
        List<Integer> l1=new ArrayList<>(4);
        l1.add(1);l1.add(3);l1.add(4);l1.add(5);
        List<Integer> l2=new ArrayList<>(0);
        l2.add(12);
        List<Integer> l3=new ArrayList<>(1);
        l3.add(2);

        List<Iterator<Integer>> list=new ArrayList<>(3);
        list.add(l1.iterator());list.add(l2.iterator());list.add(l3.iterator());
        IteratorOfIterators iter=new IteratorOfIterators(list);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
