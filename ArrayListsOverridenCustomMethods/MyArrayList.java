package ArrayListsOverridenCustomMethods;

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
     * check if size is less than 0 or size is greater than or equal to capacity, if
     * so throw an unsupported operation exception.
     * ensureCapacity()
     * add element to data[] at index of field size i.e data[size]
     * increment size
     * 
     */

    public void add(E element) {
        if (size < 0 || size >= capacity) {
            throw new UnsupportedOperationException("Unsupported operation");
        }
        ensureCapacity();
        data[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Element requested is out of bounds at index: " + index + ". The size of the array is: " + size
                            + "The capacity of the array is: " + capacity);
        }
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (size >= capacity) {
            ensureCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    // Get the element at the specified index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Element requested is out of bounds at index: " + index + ". The size of the array is: " + size
                            + "The capacity of the array is: " + capacity);
        }
        return data[index];
    }

    // Set the element at the specified index and return the old element
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Element requested is out of bounds at index: " + index + ". The size of the array is: " + size
                            + ". The capacity of the array is: " + capacity);
        }
        E oldElement = data[index];
        data[index] = element;
        return oldElement;
    }

    // Remove the element at the specified index
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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

    // Check if the list contains a specific element
    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // Find the index of the first occurrence of an element
    public int indexOf(E element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
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
        if (size == 0) {
            return true;
        }
        return false;
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
        if (size >= capacity) {
            capacity *= 2;
            E[] newData = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
}