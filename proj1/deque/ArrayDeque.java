package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size = 0;
    private int nextFirst = 0;
    private T[] item;
    private int nextLast = 0;
    private int maxsize = 8;

    public ArrayDeque() {
        size = 0;
        nextLast = 4;
        nextFirst = 3;
        maxsize = 8;
        item = (T[]) new Object[maxsize];
    }

    private int resize() {
        T[] temp = (T[]) new Object[maxsize * 2];
        for (int i = 0; i < maxsize; ++i) {
            temp[i] = item[(i + nextFirst + 1) % maxsize];
        }
        nextFirst = maxsize * 2 - 1;
        nextLast = maxsize;
        item = temp;
        return maxsize * 2;
    }

    @Override
    public void addFirst(T it) {
        if (size == maxsize) {
            maxsize = resize();
        }
        this.item[nextFirst] = it;
        size += 1;
        nextFirst = (nextFirst - 1 + maxsize) % maxsize;
    }

    @Override
    public void addLast(T it) {
        if (size == maxsize) {
            maxsize = resize();
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
        return removed;
    }

    @Override
    public T get(int index) {
        int curindex = nextFirst + 1;
        while (index != 0) {
            curindex = (curindex + 1) % maxsize;
            index--;
        }
        return item[curindex];
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int index;

        public ArrayDequeIterator() {
            index = nextFirst + 1;
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
