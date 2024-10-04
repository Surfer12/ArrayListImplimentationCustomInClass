package ArrayListsOverridenCustomMethods.HomeworkPrompts;

import java.util.Arrays;

/**
 * A custom implementation of an ArrayList that provides methods for adding,
 * removing, and accessing elements.
 * This class is designed to mimic the functionality of the standard ArrayList
 * in Java, with additional methods
 * for inserting elements at specific indices, setting elements at specific
 * indices, and checking for the presence
 * of elements within the list.
 * 
 * @param <E> The type of elements in this list.
 */
public class MyArrayListClassProjectPrompt<E> {
    private E[] data; // The array that stores the elements of the list.
    private int size; // The current number of elements in the list.
    private int capacity; // The maximum number of elements the list can hold.

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public MyArrayListClassProjectPrompt() {
        capacity = 10; // Initial capacity
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Adds an element to the end of the list. If the list is at capacity, it
     * resizes to accommodate the new element.
     * 
     * @param element The element to be added to the list.
     */
    public void add(E element) {
        ensureCapacity();
        data[size++] = element;
    }

    /**
     * Inserts an element at a specified index in the list. If the list is at
     * capacity, it resizes to accommodate the new element.
     * 
     * @param index   The index at which the element is to be inserted.
     * @param element The element to be inserted into the list.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * Retrieves the element at the specified index in the list.
     * 
     * @param index The index of the element to be retrieved.
     * @return The element at the specified index.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    /**
     * Replaces the element at the specified index in the list with a new element
     * and returns the old element.
     * 
     * @param index   The index of the element to be replaced.
     * @param element The new element to replace the old element.
     * @return The old element that was replaced.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldElement = data[index];
        data[index] = element;
        return oldElement;
    }

    /**
     * Removes the element at the specified index in the list and shifts all
     * subsequent elements to the left.
     * 
     * @param index The index of the element to be removed.
     * @return The element that was removed from the list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; // Clear to let GC do its work
        return removedElement;
    }

    /**
     * Checks if the list contains a specific element.
     * 
     * @param element The element to be searched for in the list.
     * @return true if the list contains the element, false otherwise.
     */
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * Finds the index of the first occurrence of an element in the list.
     * 
     * @param element The element to be searched for in the list.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the current size of the list.
     * 
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * 
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list by setting all elements to null and resetting the size to 0.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Ensures the list has sufficient capacity to accommodate new elements. If the
     * list is at capacity, it resizes to accommodate more elements.
     */
    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = capacity * 3 / 2 + 1;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
    }
}
