import java.util.ArrayList;

/**
 * CustomArrayList is a subclass of ArrayList that overrides some of its
 * methods.
 * This class demonstrates how to extend and customize the behavior of an
 * ArrayList.
 */
/* public class CustomArrayListGH<E> extends ArrayList<E> { */

/**
 * Adds an element to the list.
 * 
 * @param e the element to be added
 * @return true if the element was added successfully
 */
@Override
public boolean add(E e) {
    System.out.println("Adding element: " + e);
    return super.add(e);
}

/**
 * Removes an element from the list.
 * 
 * @param o the element to be removed
 * @return true if the element was removed successfully
 */
@Override
public boolean remove(Object o) {
    System.out.println("Removing element: " + o);
    return super.remove(o);
}

/**
 * Retrieves an element at a specific index.
 * 
 * @param index the index of the element to be retrieved
 * @return the element at the specified index
 */
@Override
public E get(int index) {
    System.out.println("Getting element at index: " + index);
    return super.get(index);
}

/**
 * Main method to demonstrate the usage of CustomArrayList.
 */
public static void main(String[] args) {
    CustomArrayList<String> list = new CustomArrayList<>();
    list.add("Hello");
    list.add("World");
    System.out.println(list.get(0));
    list.remove("Hello");
}
/*
 * <!--###Notes-**Class Declaration**:`CustomArrayList`extends`ArrayList`
 * to inherit
 * its properties
 * and methods.-**Override`add`Method**:
 * Adds an
 * element to
 * the list
 * and prints
 * a message.-**Override`remove`Method**:
 * Removes an
 * element from
 * the list
 * and prints
 * a message.-**Override`get`Method**:
 * Retrieves an
 * element at
 * a specific
 * index and
 * prints a message.-**Main Method**:
 * Demonstrates the
 * usage of
 * the overridden
 * methods in`CustomArrayList`.
 * 
 * This code
 * provides a
 * basic structure for
 * extending and
 * customizing an`ArrayList`
 * in Java.--
 * >
 */