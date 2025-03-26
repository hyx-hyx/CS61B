package deque;

import java.util.Iterator;


public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class LinkedListNode<T> {
        LinkedListNode<T> prev;
        T item;
        LinkedListNode<T> next;

        LinkedListNode() {
            prev = this;
            next = this;
            item = null;
        }

        public LinkedListNode(T e) {
            prev = this;
            next = this;
            item = e;
        }
    }

    private LinkedListNode<T> sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new LinkedListNode<T>();
    }

    public void addFirst(T item) {
        LinkedListNode<T> first = new LinkedListNode<>(item);
        first.prev = sentinel;
        first.next = sentinel.next;
        sentinel.next.prev = first;
        sentinel.next = first;

        size += 1;
    }

    public void addLast(T item) {
        LinkedListNode<T> last = new LinkedListNode<>(item);

        last.prev = sentinel.prev;
        last.next = sentinel;
        sentinel.prev.next = last;
        sentinel.prev = last;

        size += 1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        LinkedListNode<T> removedNode = sentinel.next;
        removedNode.next.prev = sentinel;
        sentinel.next = removedNode.next;

        size -= 1;
        return removedNode.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        LinkedListNode<T> removedNode = sentinel.prev;
        removedNode.prev.next = sentinel;
        sentinel.prev = removedNode.prev;

        size -= 1;
        return removedNode.item;

    }

    public T get(int index) {
        for (T t : this) {
            if (index == 0) {
                return t;
            }
            index--;
        }
        return null;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private LinkedListNode<T> node;

        @Override
        public boolean hasNext() {
            return node.next != sentinel;
        }

        @Override
        public T next() {
            node = node.next;
            return node.item;
        }

        LinkedListDequeIterator() {
            node = sentinel;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o) {
        Iterator<T> iter1 = iterator();
        if (o instanceof LinkedListDeque) {
            LinkedListDeque other = (LinkedListDeque) o;
            Iterator<T> iter2 = other.iterator();
            while (iter1.hasNext()) {
                if (iter1.hasNext() != iter2.hasNext()) {
                    return false;
                }
                if (!(iter1.next().equals(iter2.next()))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private T getRecursiveHelper(LinkedListNode<T> cur, int index) {
        if (index == 0) {
            return cur.item;
        }
        return getRecursiveHelper(cur.next, index - 1);
    }

    public T getRecursive(int index) {
        LinkedListNode<T> cur = sentinel;
        return getRecursiveHelper(cur, index);
    }
}
