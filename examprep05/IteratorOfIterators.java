import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorOfIterators implements Iterator {

    List<Iterator<Integer>> L;
    int iterIndex;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        iterIndex=0;
        L=a;
    }
    @Override
    public boolean hasNext() {
        int size=L.size();
        while(size>0){
            if(L.get(iterIndex).hasNext()){
                return true;
            }
            iterIndex=(iterIndex+1)%L.size();
            size--;
        }
        return false;
    }

    @Override
    public Integer next(){
        Integer v=L.get(iterIndex).next();
        iterIndex=(iterIndex+1)%L.size();
        return v;
    }
}
