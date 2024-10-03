Copying the array from the size backwards rather than forwards is essential for maintaining the integrity of the elements in the array when inserting a new element. Here's a breakdown of the reasoning:

1. **Preservation of Existing Elements**: When you insert an element at a specific index, you need to shift the existing elements to the right to make space for the new element. If you were to copy from the front (index 0) to the back, you would overwrite elements that you still need to shift.

2. **Avoiding Overwrites**: By starting from the last element (`size - 1`) and moving towards the specified index, you ensure that you are not overwriting any elements that have not yet been moved. This way, the element at `data[index]` can be safely assigned the new value without losing any existing data.

3. **Correct Indexing**: The loop condition `i >= index` ensures that all elements from the specified index to the end of the list are shifted one position to the right. This is necessary because the new element will occupy the `index` position, and all subsequent elements need to be moved to maintain their order.

4. **Efficiency**: This method of shifting elements is efficient because it only requires a single pass through the elements that need to be moved, ensuring that the operation remains linear in time complexity, O(n), where n is the number of elements in the list.

In summary, copying from the size backwards ensures that existing elements are preserved and correctly shifted to accommodate the new element without any data loss.

The `remove` method you provided has a small issue in the loop that shifts elements after removing an element. The loop should iterate from `index + 1` to `size`, not from `size - 1` to `index`. Here's the corrected version:

```java:ArrayListsOverridenCustomMethods/MyArrayList.java
    // Remove the element at the specified index
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            for (int i = index + 1; i < size; i++) { // Corrected loop
                data[i - 1] = data[i]; // Shift elements left
            }
        }
        data[--size] = null; // Clear to let GC do its work
        return removedElement;
    }
```

### Explanation of Changes:
- The loop now starts from `index + 1` and goes to `size`, shifting elements left to fill the gap left by the removed element.