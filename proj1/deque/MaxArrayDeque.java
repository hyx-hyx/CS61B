package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (this.size() <= 0) {
            return null;
        }
        T maxv = null;
        for (T t : this) {
            if (maxv == null || comparator.compare(t, maxv) > 0) {
                maxv = t;
            }
        }
        return maxv;
    }

    public T max(Comparator<T> c) {
        if (this.size() <= 0) {
            return null;
        }
        T maxv = null;
        for (T t : this) {
            if (maxv == null || c.compare(t, maxv) > 0) {
                maxv = t;
            }
        }
        return maxv;
    }

}
