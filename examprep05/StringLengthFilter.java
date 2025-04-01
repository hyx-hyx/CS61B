public class StringLengthFilter<T> implements Predicate<T> {

    @Override
    public boolean test(T x) {
        if (x instanceof String) {
            return ((String) x).length() > 5;
        }
        return false;
    }
}
