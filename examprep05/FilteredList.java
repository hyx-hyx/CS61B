import java.util.Iterator;
import java.util.List;

public class FilteredList<T> implements Iterable<T> {

    List<T> L;
    Predicate<T> filter;
    public FilteredList (List<T> L, Predicate<T> filter){
        this.L=L;
        this.filter=filter;
    }
    private class FilteredListIterator implements Iterator<T>{

        int index=0;
        @Override
        public boolean hasNext() {
            while(index<L.size()) {
                if (filter.test(L.get(index))) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public T next() {
            T v=L.get(index);
            index++;
            return v;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new FilteredListIterator();
    }
}
