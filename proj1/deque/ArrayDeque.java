package deque;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDeque<T> implements Deque<T> {
    private int size=0;
    private int nextFirst=0;
    private T[] item;
    private int nextLast=0;
    private int maxsize=8;

    public ArrayDeque(){
        size=0;
        nextLast=4;
        nextFirst=3;
        maxsize=8;
        item=(T[])new Object[maxsize];
    }
    private int resize(){
        T[] temp=(T[])new Object[maxsize*2];
        for(int i=0;i<nextLast;++i)
            temp[i]=item[i];
        for(int i=nextFirst+1;i<maxsize;++i)
            temp[i+maxsize]=item[i];
        item=temp;
        return maxsize*2;
    }
    @Override
    public void addFirst(T item) {
        if(size==maxsize){
            maxsize=resize();
        }
        this.item[nextFirst]=item;
        size+=1;
        nextFirst=(nextFirst-1+size)%maxsize;
    }

    @Override
    public void addLast(T item) {
        if(size==maxsize){
            maxsize=resize();
        }
        this.item[nextLast]=item;
        size+=1;
        nextLast=(nextLast+1)%maxsize;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        if(size==0)
            return null;
        ++nextFirst;
        if(nextFirst>=maxsize) nextFirst%=maxsize;
        T removed=item[nextFirst];

        size-=1;
        return removed;
    }

    @Override
    public T removeLast() {
        if(size==0)
            return null;
        --nextLast;
        if(nextLast<0) {
            nextLast+=maxsize;
            nextLast%=maxsize;
        }
        T removed=item[nextLast];

        size-=1;
        return removed;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
