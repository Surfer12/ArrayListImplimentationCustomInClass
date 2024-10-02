Here’s a breakdown of the null and index bounds checking implemented in your methods, along with the relevant exception handling:

### Null Checking
- **`indexOf(E element)`**:
  ```java
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
  ```

### Index Bounds Checking
- **`add(int index, E element)`**:
  ```java
  if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }
  ```

- **`get(int index)`**:
  ```java
  if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }
  ```

- **`set(int index, E element)`**:
  ```java
  if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }
  ```

- **`remove(int index)`**:
  ```java
  if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }
  ```

### Exception Handling
- **Throwing Exceptions**:
  - All methods that perform index bounds checking throw an `IndexOutOfBoundsException` when the index is invalid.
  
### Summary
- **Null Checking**: Implemented in `indexOf(E element)` to handle cases where the element being searched for is `null`.
- **Index Bounds Checking**: Implemented in `add(int index, E element)`, `get(int index)`, `set(int index, E element)`, and `remove(int index)` to ensure that the index is within valid bounds before performing operations.
- **Exception Handling**: Uses `throw` statements to raise `IndexOutOfBoundsException` when invalid indices are accessed.

This approach ensures that your methods are robust and handle edge cases effectively.

Here’s a breakdown of the null and index bounds checking, along with exception handling for the remaining methods in your `MyArrayList` implementation:

### 1. `contains(E element)`
- **Null Checking**:
  - Uses `indexOf` to check if the element exists.
- **Implementation**:
  ```java
  public boolean contains(E element) {
      return indexOf(element) >= 0; // Uses indexOf for checking
  }
  ```

### 2. `indexOf(E element)`
- **Null Checking**:
  - Checks if the `element` is `null` and handles it accordingly.
- **Implementation**:
  ```java
  public int indexOf(E element) {
      if (element == null) {
          for (int i = 0; i < size; i++) {
              if (data[i] == null) {
                  return i; // Found null element
              }
          }
      } else {
          for (int i = 0; i < size; i++) {
              if (element.equals(data[i])) {
                  return i; // Found matching element
              }
          }
      }
      return -1; // Not found
  }
  ```

### 3. `size()`
- **No Null or Index Checking**:
  - Simply returns the size of the list.
- **Implementation**:
  ```java
  public int size() {
      return size; // No checks needed
  }
  ```

### 4. `isEmpty()`
- **No Null or Index Checking**:
  - Checks if the size is zero.
- **Implementation**:
  ```java
  public boolean isEmpty() {
      return size == 0; // No checks needed
  }
  ```

### 5. `clear()`
- **No Null or Index Checking**:
  - Resets the size and clears the array.
- **Implementation**:
  ```java
  public void clear() {
      for (int i = 0; i < size; i++) {
          data[i] = null; // Clear references for GC
      }
      size = 0; // Reset size
  }
  ```

### 6. `ensureCapacity()`
- **No Null or Index Checking**:
  - Checks if resizing is needed based on the current size and capacity.
- **Implementation**:
  ```java
  private void ensureCapacity() {
      if (size == capacity) {
          int newCapacity = capacity * 3 / 2 + 1; // Increase capacity
          data = Arrays.copyOf(data, newCapacity); // Resize array
          capacity = newCapacity; // Update capacity
      }
  }
  ```

### Summary
- **Null Checking**: Implemented in `indexOf(E element)` to handle potential `null` values.
- **Index Bounds Checking**: Not applicable for `contains`, `indexOf`, `size`, `isEmpty`, `clear`, and `ensureCapacity` as they do not require index access.
- **Exception Handling**: The methods that require index access (`add`, `get`, `set`, `remove`) throw `IndexOutOfBoundsException` when the index is invalid.

This structure ensures that your methods are robust and handle edge cases effectively, adhering to the principles of the Java Collections framework.