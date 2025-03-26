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
        T[] temp = (T[]) new Object[newsize];
        for (int i = 0; i < size; ++i) {
            temp[i] = item[(i + nextFirst + 1) % maxsize];
        }
        nextFirst = newsize - 1;
        nextLast = size;
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
        int curindex = (nextFirst + 1) % maxsize;
        while (index != 0) {
            curindex = (curindex + 1) % maxsize;
            index--;
        }
        return item[curindex];
    }

    @Override
    public boolean equals(Object o) {
        Iterator<T> iter1 = iterator();
        if (o instanceof ArrayDeque) {
            ArrayDeque other = (ArrayDeque) o;
            if (this.size() != other.size()) {
                return false;
            }
            Iterator<T> iter2 = other.iterator();
            while (iter1.hasNext()) {
                if (!(iter1.next().equals(iter2.next()))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int index;

        public ArrayDequeIterator() {
            index = (nextFirst + 1) % maxsize;
        }

        @Override
        public boolean hasNext() {
            return index != nextLast;
        }

        @Override
        public T next() {
            T v = item[index];
            index++;
            return v;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
}
