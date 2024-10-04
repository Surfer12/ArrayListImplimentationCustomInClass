package ArrayListsOverridenCustomMethods;

import java.util.Arrays;

public class MyArrayList<E> {
    private E[] data;
    private int size; // Keeps track of the number of elements in the arrayList, also the index of the
                      // next available slot. Allows knowledge of how many elements are in the
                      // arrayList, as well as ensures essential functions such as add() and remove()
                      // work properly. Retrieval, iteration and checking if the list is empty are all
                      // dependent on this variable.
    private int capacity; // Determines the physical size of the array. The physical size of the array
                          // is always >= the number of elements in the arrayList.

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        capacity = 10; // Initial capacity
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /*
     * Pseudocode: for add(E element):
     * check if array needs resizing, which would be if size = capacity;
     * if so, call ensureCapacity()
     * add element to data[] at index of field size i.e data[size]
     * increment size
     * 
     */

    public void add(E element) {
        if (size == capacity) {
            ensureCapacity();
        }
        data[size++] = element; // add the element to the array at the index of size, then increment size
    }

    // Check if index is out of bounds, if so throw an exception
    // Check if element is null, if so throw an exception
    // Check if size is == capacity, if so call ensureCapacity()
    // add the element to the array at the index of size, then increment size
    public void add(int index, E element) {
        checkIndex(index);
        checkElement(element);
        if (size == capacity) {
            ensureCapacity();
        }
        System.arraycopy(data, index, data, index + 1, size - index); // void, source array, start index of source,
                                                                      // destination array, start index of destination,
                                                                      // length of copy (size - index)
        data[index] = element;
        size++;
    }

    // Get the element at the specified index
    // Check if index is out of bounds, if so throw an exception
    // Return the element at the specified index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    // Set the element at the specified index and return the old element
    // Check if index is out of bounds, if so throw an exception
    // Check if element is null, if so throw an exception
    // Set the element at the specified index and return the old element
    public E set(int index, E element) {
        checkIndex(index);
        checkElement(element);
        E oldElement = data[index]; // use temp swap variable to store the old element
        data[index] = element; // set the element at the specified index to the new element
        return oldElement; // return the old element
    }

    // Remove the element at the specified index
    // Check if index is out of bounds, if so throw an exception
    // Return the element at the specified index
    public E remove(int index) {
        checkIndex(index);
        E removedElement = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i]; // Shift elements left
            }
        }
        data[--size] = null; // Clear to let GC do its work
        return removedElement;
    }

    // Check if element is null, if so throw an exception
    // Check if the list contains a specific element
    public boolean contains(E element) {
        checkElement(element);
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // Find the index of the first occurrence of an element
    // Check if element is null, if so throw an exception
    // Loop through the array and return the index of the first occurrence of the
    // element
    public int indexOf(E element) {
        checkElement(element);
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Get the current size of the list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear the list
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // If size equals capacity:
    // New capacity is updated to capacity *= 2
    // create a new array with the new capacity
    // copy the elements from the old array to the new array
    // set data to the new array
    // update capacity to the new capacity
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = capacity * 2;
            E[] newData = (E[]) new Object[newCapacity];
            newData = Arrays.copyOf(data, newCapacity);
            data = newData;
            capacity = newCapacity;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkElement(E element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
    }
}