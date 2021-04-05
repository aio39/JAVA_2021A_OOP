package chap15;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable {
    Object[] array;

    private int capacity = 10;

    private int size = 0;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(T value) {

        if (size >= capacity) {
            int increasedCapacity = (int) (capacity * 1.5);
            T[] tmpArray = (T[]) new Object[increasedCapacity];
            // for (int i = 0; i < size; i++) {
            // tmpArray[i] = array[i];
            // }
            System.arraycopy(array, 0, tmpArray, 0, size);
            array = tmpArray;

            capacity = increasedCapacity;

        }
        array[size++] = value;

    }

    public T get(int idx) {
        return (T) array[idx];
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        
        return null;
    }

}
