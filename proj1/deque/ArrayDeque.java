package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int nextFirst;
    private T[] item;
    private int nextLast;
    private int maxsize;

    public ArrayDeque() {
        size = 0;
        nextLast = 4;
        nextFirst = 3;
        maxsize = 8;
        item = (T[]) new Object[maxsize];
    }

    private int resize(int newsize) {
        if (newsize < 8) {
            return 8;
        }
        T[] temp = (T[]) new Object[newsize];
        for (int i = 0; i < size; ++i) {
            temp[i] = item[(i + nextFirst + 1) % maxsize];
        }
        nextFirst = newsize - 1;
        nextLast = size % newsize; //取模是为了在缩小maxsize的时候把nextlast放在索引0的位置
        item = temp;
        return newsize;
    }

    @Override
    public void addFirst(T it) {
        if (size == maxsize) {
            maxsize = resize(maxsize * 2);
        }
        this.item[nextFirst] = it;
        size += 1;
        nextFirst = (nextFirst - 1 + maxsize) % maxsize;
    }

    @Override
    public void addLast(T it) {
        if (size == maxsize) {
            maxsize = resize(maxsize * 2);
        }
        this.item[nextLast] = it;
        size += 1;
        nextLast = (nextLast + 1) % maxsize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (T t : this) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ++nextFirst;
        if (nextFirst >= maxsize) {
            nextFirst %= maxsize;
        }
        T removed = item[nextFirst];

        size -= 1;
        if (size == maxsize / 2) {
            maxsize = resize(maxsize / 2);
        }
        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        --nextLast;
        if (nextLast < 0) {
            nextLast += maxsize;
            nextLast %= maxsize;
        }
        T removed = item[nextLast];
        size -= 1;
        if (size == maxsize / 2) {
            maxsize = resize(maxsize / 2);
        }
        return removed;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int curindex = (nextFirst + 1) % maxsize;
        while (index != 0) {
            curindex = (curindex + 1) % maxsize;
            index--;
        }
        return item[curindex];
    }

    @Override
    public boolean equals(Object o) {
        Deque other;
        Iterator iter2;
        if (o instanceof ArrayDeque) {
            other = (ArrayDeque) o;
            iter2 = ((ArrayDeque) other).iterator();
        } else if (o instanceof LinkedListDeque) {
            other = (LinkedListDeque) o;
            iter2 = ((LinkedListDeque) other).iterator();
        } else {
            return false;
        }

        if (this.size() != other.size()) {
            return false;
        }

        Iterator iter1 = iterator();
        while (iter1.hasNext()) {
            if (!(iter1.next().equals(iter2.next()))) {
                return false;
            }
        }
        return true;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int index;
        int itersize;

        ArrayDequeIterator() {
            index = (nextFirst + 1) % maxsize;
            itersize = size;
        }

        @Override
        public boolean hasNext() {
            return itersize > 0;
        }

        @Override
        public T next() {
            T v = item[index];
            index = (index + 1) % maxsize;
            itersize--;
            return v;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T t : this) {
            str.append(t.toString());
            str.append(" ");
        }
        return str.toString();
    }
}
