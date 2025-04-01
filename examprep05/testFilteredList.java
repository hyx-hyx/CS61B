import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testFilteredList {
    @Test
    public void testStringLength(){
        List<String> L=new ArrayList<>();
        L.add("asas");
        L.add("dasgsdad");
        L.add("asdfagasd");
        L.add("sdaf");
        FilteredList<String> FL = new FilteredList<>(L, new StringLengthFilter<>());
        for(String s:FL){
            System.out.println(s);
        }
    }
}
