package ArrayListsOverridenCustomMethods;

import java.util.ArrayList;

public class MyArrayList<E> {
    private E[] data;
    private int size; //
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        capacity = 10; // Initial capacity
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /*
     * Pseudocode:
     * If size of the arrayList is zero or size is greater than or equal to capacity
     * Call ensureCapacity()
     * After that check, add the element at the size index i.e add the element at
     * the last of the arrayList. This is add element to data[size]
     * Increment the size of the array.
     */

    public void add(E element) {

    }

    // Insert an element at a specific index
    public void add(int index, E element) {
        // ... implementation to be added ...
        // If size is at == 0 or is >= capacity, resize capacity.
        // Add the element at the specified index
        // Increment size
    }

    // Get the element at the specified index
    public E get(int index) {
        // ... implementation to be added ...
    }

    // Set the element at the specified index and return the old element
    public E set(int index, E element) {
        // ... implementation to be added ...
    }

    // Remove the element at the specified index
    public E remove(int index) {
        // ... implementation to be added ...
    }

    // Check if the list contains a specific element
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Find the index of the first occurrence of an element
    public int indexOf(E element) {
        // ... implementation to be added ...
    }

    // Get the current size of the list
    public int size() {
        // ... implementation to be added ...
    }

    // Check if the list is empty
    public boolean isEmpty() {
        // ... implementation to be added ...
    }

    // Clear the list
    public void clear() {
        // ... implementation to be added ...
    }

    // Increase the capacity of the array if needed
    private void ensureCapacity() {
        // ... implementation to be added ...
    }
}