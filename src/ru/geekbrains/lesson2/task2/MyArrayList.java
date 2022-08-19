package ru.geekbrains.lesson2.task2;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initCapacity) {
        if (initCapacity >= 0) {
            elementData = new Object[initCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
        }
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = e;
        size = s + 1;
    }

    public boolean add(E e) {
        add(e, elementData, size);
        return true;
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        final int s = size;
        Object[] elementData = this.elementData;
        if (s == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        size = s + 1;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (minCapacity < 0) {
                throw new OutOfMemoryError();
            }
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return newCapacity;
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        remove(es, index);

        return oldValue;
    }

    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        remove(es, i);
        return true;
    }

    private void remove(Object[] el, int index) {
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(el, index + 1, el, index, newSize - index);
        }
        size = newSize;
        el[size] = null;
    }

    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}
