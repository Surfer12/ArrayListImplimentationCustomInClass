package ArrayListsOverridenCustomMethods;

import java.util.Arrays;

/**
 * The MyArrayList class represents a custom implementation of an ArrayList.
 * It provides methods to add, remove, get, set, and manipulate elements in the
 * list.
 * The class uses an underlying array to store the elements and dynamically
 * resizes the array when needed.
 * The size of the list is automatically adjusted as elements are added or
 * removed.
 *
 * @param <E> the type of elements stored in the list
 */
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
     * for add(E element):
     * check if array needs resizing, which would be if size = capacity;
     * if so, call ensureCapacity()
     * add element to data[] at index of field size i.e data[size]
     * increment size
     * 
     * 
     * 
     */

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added
     */
    public void add(E element) {
        if (checkIfSizeIsEqualToCapacity()) {
            ensureCapacity();
        }
        data[size++] = element; // add the element to the array at the index of size, then increment size
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   the index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     * 
     *                                   for add(int index, E element):
     *                                   check if index is out of bounds, if so
     *                                   throw an exception
     *                                   check if element is null, if so throw an
     *                                   exception
     *                                   check if size is == capacity, if so call
     *                                   ensureCapacity()
     *                                   add the element to the array at the index
     *                                   of size, then increment size
     * 
     */
    public void add(int index, E element) {
        checkIndex(index);
        checkElementPointer(element);
        if (size == capacity) {
            ensureCapacity();
        }
        System.arraycopy(data, index, data, index + 1, size - index); // void, source array, start index of source,
                                                                      // destination array, start index of destination,
                                                                      // length of copy (size - index)
        data[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified index in this list.
     * 
     * for get(int index):
     * check if index is out of bounds, if so throw an exception
     * return the element at the specified index
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * for set(int index, E element):
     * check if index is out of bounds, if so throw an exception
     * check if element is null, if so throw an exception
     * set the element at the specified index to the new element
     * return the old element
     * 
     * @param index   the index of the element to be replaced
     * @param element the element to be stored at the specified index
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E element) {
        checkIndex(index);
        checkElementPointer(element);
        E oldElement = data[index]; // use temp swap variable to store the old element
        data[index] = element; // set the element at the specified index to the new element
        return oldElement; // return the old element
    }

    /**
     * Removes the element at the specified index from this list.
     * // Remove the element at the specified index
     * // Check if index is out of bounds, if so throw an exception
     * // Return the element at the specified index
     * 
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
     *                                   index >= size())
     */
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

    /**
     * Returns true if this list contains the specified element.
     * // Check if element is null, if so throw an exception
     * // Check if the list contains a specific element
     * 
     * 
     * @param element the element to be checked for containment in this list
     * @return true if this list contains the specified element, false otherwise
     */
    public boolean contains(E element) {
        checkElementPointer(element);
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this
     * list,
     * or -1 if this list does not contain the element.
     *
     * // Find the index of the first occurrence of an element
     * // Check if element is null, if so throw an exception
     * // Loop through the array and return the index of the first occurrence of the
     * // element
     * 
     * @param element the element to search for
     * @return the index of the first occurrence of the specified element in this
     *         list,
     *         or -1 if this list does not contain the element
     * @throws NullPointerException if the specified element is null
     */
    public int indexOf(E element) {
        checkElementPointer(element);
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Get the current size of the list
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    // Check if the list is empty
    /**
     * Checks if the ArrayList is empty.
     *
     * @return true if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return checkIfSizeIsZero();
    }

    // Clear the list
    /**
     * Removes all elements from the list.
     * After calling this method, the list will be empty.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Clears the ArrayList by filling the underlying array with null values and
     * resetting the size to 0.
     */
    public void clearWithArraysFill() {
        Arrays.fill(data, null);
        size = 0;
    }

    /**
     * Ensures that the underlying array has enough capacity to accommodate
     * additional elements.
     * If the current size of the array is equal to its capacity, the capacity is
     * doubled and the elements are copied to the new array.
     * // If size equals capacity:
     * // New capacity is updated to capacity *= 2
     * // create a new array with the new capacity
     * // copy the elements from the old array to the new array
     * // set data to the new array
     * // update capacity to the new capacity
     */
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

    /**
     * Checks if the given index is within the valid range of the list.
     * 
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Checks if the given element is null.
     * 
     * @param element the element to check
     * @throws NullPointerException if the element is null
     */
    private void checkElementPointer(E element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
    }

    /**
     * Checks if the size of the ArrayList is zero.
     * 
     * @return true if the size is zero, false otherwise.
     */
    private boolean checkIfSizeIsZero() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the current size of the ArrayList is equal to its capacity.
     * 
     * @return true if the size is equal to the capacity, false otherwise.
     */
    private boolean checkIfSizeIsEqualToCapacity() {
        if (size == capacity) {
            return true;
        }
        return false;
    }
}
