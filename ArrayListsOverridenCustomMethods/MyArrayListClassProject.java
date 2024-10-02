package ArrayListsOverridenCustomMethods;

import java.util.ArrayList;

public class MyArrayListClassProject<E> {
    private E[] data;
    private int size;
    private int capacity;

    public MyArrayListClassProject() {
        capacity = 10; // Initial capacity
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // Add an element at the end of the list
    public void add(E element) {

    }

    // Insert an element at a specific index
    public void add(int index, E element) {
        // ... implementation to be added ...
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
}
