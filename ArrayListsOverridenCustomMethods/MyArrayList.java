package ArrayListsOverridenCustomMethods;

import java.util.ArrayList;

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
     * Pseudocode:
     * If size of the arrayList is zero or size is greater than or equal to capacity
     * Call ensureCapacity()
     * After that check, add the element at the size index i.e add the element at
     * the last of the arrayList. This is add element to data[size]
     * Increment the size of the array.
     */

    public void add(E element) {
        if (size < 0 || size >= capacity) {
            ensureCapacity();
        }
        data[size++] = element
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

    // ... implementation to be added ...
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

    // If size equals capacity:
    // New capacity is updated to capacity *= 2
    // create a new array with the new capacity
    // copy the elements from the old array to the new array
    // set data to the new array
    // update capacity to the new capacity
    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
        }
    }
}