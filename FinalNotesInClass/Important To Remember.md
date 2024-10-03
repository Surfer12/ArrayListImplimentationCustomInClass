### Important To Remember
For the class diagram:
* Include variables with their data types
* Include function names with their return type, and parameters with their data type if any
```java
class Animal{
String name;
void setName(string name){}
String getName(){}
}
```
For the flowchart make sure to use correct symbols (check out flowchart notes).
------------------------------------------------------------------------------------------------------------------------------------------
### Time analysis
#### O(n) - Single Loop
```java
public void printNumbers(int n) {
 for (int i = 0; i < n; i++) {
 System.out.println(i);
 }
}
```
In this example, the loop iterates n times. Each iteration takes roughly the same amount of time 
(printing to the console). Since the number of operations grows linearly with n, this is O(n) time 
complexity.
#### Animal
* String name
* void setName(string name)
* String getName()
#### O(n^2) - Nested Loops
```java
public void printPairs(int n) {
 for (int i = 0; i < n; i++) {
 for (int j = 0; j < n; j++) {
 System.out.println(i + ", " + j);
 }
 }
}
```
Here, we have a loop nested inside another loop. The outer loop runs n times, and for each of 
those iterations, the inner loop also runs n times. This results in n * n total iterations, giving us 
O(n^2) time complexity.
#### Why Nested Loops Often Mean O(n^2)
Nested loops often lead to O(n^2) because you're performing an operation for every possible 
pair of elements in your input. Imagine you have a list of numbers, and you want to compare 
each number to every other number in the list. You'd use nested loops to achieve this, resulting 
in that quadratic increase in runtime.
#### Important Note:
While nested loops often indicate O(n^2), it's not always the case. The inner 
loop's behavior and how its iterations relate to the outer loop can significantly impact the 
overall time complexity.
### Big O Notation Cheat Sheet
* **O(1) - Constant Time:** The algorithm takes the same amount of time, regardless of the 
input size.
	+ Example: Accessing an element in an array by its index.
* **O(log n) - Logarithmic Time:** The time grows slowly as the input size increases. Often 
involves dividing the problem in half repeatedly.
	+ Example: Binary search in a sorted array.
* **O(n) - Linear Time:** The time increases linearly with the input size.
	+ Example: Iterating through an array.
* **O(n log n) - Log-linear Time:** A combination of linear and logarithmic behavior. Common 
in efficient sorting algorithms.
	+ Example: Merge sort, Quick sort.
* **O(n^2) - Quadratic Time:** Time grows proportionally to the square of the input size. 
Often involves nested loops.
	+ Example: Bubble sort, Selection sort.
* **O(2^n) - Exponential Time:** Time doubles with each addition to the input. Can become 
very slow quickly.
	+ Example: Finding all subsets of a set.
* **O(n!) - Factorial Time:** Grows extremely fast. Often involves generating all 
permutations.
	+ Example: Traveling Salesperson Problem (brute-force solution).
### Key Concepts
* **Worst-Case Scenario:** Big O usually focuses on the worst-case runtime.
* **Drop Constants and Lower-Order Terms:** Simplify expressions (e.g., O(2n + 5) becomes 
O(n)).
* **Focus on Dominant Terms:** In O(n^2 + n), the n^2 term dominates as n grows large.
### Common Data Structure Operations
| Operation | Array | Linked List | Hash Table (Average) |
| --- | --- | --- | --- |
| Access | O(1) | O(n) | O(1) |
| Search | O(n) | O(n) | O(1) |
| Insertion | O(n) | O(1) | O(1) |
| Deletion | O(n) | O(1) | O(1) |
### Tips for Analysis
1. **Identify Basic Operations:** What are the fundamental steps the algorithm takes?
2. **Count Operations:** How many times are these steps executed?
3. **Express Count as a Function of Input Size:** Use Big O to represent this relationship
### Big-O Algorithm Complexity Cheat Sheet (Know Thy Complexities!) @ericdrowell (bigocheatsheet.com)

Hash table: Review 

Here's a simple example of a hash table implementation in Java using a custom class. This example will cover basic operations such as access, search, insertion, and deletion. We'll use an array of linked lists to handle collisions using chaining.

A hashing function in the context of a hash table is crucial for efficiently mapping keys to specific locations (or "buckets") in the hash table. Here's how it plays into the overall functionality of a hash table:

### Purpose of Hashing Function
1. **Mapping Keys to Array Indices**: The primary role of a hashing function is to take an input key and convert it into an integer index. This index determines where the corresponding value will be stored in the hash table's underlying array.

2. **Efficiency**: A good hashing function distributes keys uniformly across the hash table. This uniform distribution helps in balancing the data across the table, which minimizes the chances of "collisions" (i.e., different keys hashing to the same index).

3. **Speed**: Hashing functions are designed to be fast to compute, allowing for quick access, insertion, and deletion operations. The speed of these operations is typically O(1) on average, thanks to efficient hashing.

### How It Works in a Hash Table
- **Insertion (`put`)**: When inserting a new key-value pair, the hash function computes an index based on the key. The key-value pair is then stored in the list at that index.
- **Retrieval (`get`)**: To retrieve a value, the hash function computes the index for the key, and the function then checks the list at that index to find the value.
- **Collision Handling**: If two keys hash to the same index, collision handling strategies such as chaining (using linked lists or another form of list at each index) or open addressing (finding another open slot in the table) are used.

### Example from Provided Code
In the provided Java code, the `hashKey` method is the hashing function:
```java
private int hashKey(int key) {
    return key % TABLE_SIZE;
}
```
This function uses the modulo operator to ensure that the hash value (index) is within the bounds of the table size. This simple approach ensures that every possible key maps to a valid index within the array.

### Conclusion
The hashing function is fundamental to the performance and efficiency of a hash table. It directly affects how well the data is distributed across the table, which in turn impacts the average time complexity of various operations. A poorly designed hash function can lead to many collisions, which would degrade the performance of the hash table to O(n) in the worst case, where n is the number of elements in the table.

```java
import java.util.LinkedList;

class HashTable {
    private final static int TABLE_SIZE = 128;
    private LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashKey(int key) {
        return key % TABLE_SIZE;
    }

    // Insertion: Adds a key-value pair to the hash table
    public void put(int key, String value) {
        int hash = hashKey(key);
        for (Entry e : table[hash]) {
            if (e.key == key) {
                e.value = value; // Update existing key
                return;
            }
        }
        table[hash].add(new Entry(key, value));
    }

    // Access: Retrieves a value by key
    public String get(int key) {
        int hash = hashKey(key);
        for (Entry e : table[hash]) {
            if (e.key == key) {
                return e.value;
            }
        }
        return null; // Key not found
    }

    // Search: Determines if a key exists in the hash table
    public boolean containsKey(int key) {
        int hash = hashKey(key);
        for (Entry e : table[hash]) {
            if (e.key == key) {
                return true;
            }
        }
        return false;
    }

    // Deletion: Removes a key-value pair by key
    public void remove(int key) {
        int hash = hashKey(key);
        Entry toRemove = null;
        for (Entry e : table[hash]) {
            if (e.key == key) {
                toRemove = e;
                break;
            }
        }
        if (toRemove != null) {
            table[hash].remove(toRemove);
        }
    }

    // Helper class to represent key-value pairs
    static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(1, "One");
        ht.put(2, "Two");
        ht.put(3, "Three");

        System.out.println("Value for key 2: " + ht.get(2)); // Access
        System.out.println("Contains key 3: " + ht.containsKey(3)); // Search
        ht.remove(2); // Deletion
        System.out.println("Contains key 2 after deletion: " + ht.containsKey(2)); // Search after deletion
    }
}
```

### Explanation:
- **HashTable Class**: This class uses an array of linked lists to store entries. Each entry is a key-value pair stored in a linked list to handle collisions.
- **Hash Function**: `hashKey` method computes the hash for a key using modulo operation.
- **Operations**:
  - **Insertion (`put`)**: Adds a new entry or updates an existing entry.
  - **Access (`get`)**: Retrieves the value associated with a given key.
  - **Search (`containsKey`)**: Checks if a key exists in the hash table.
  - **Deletion (`remove`)**: Removes the entry associated with a given key.

This implementation provides a basic understanding of how hash tables function with operations for access, search, insertion, and deletion.

Here are Java implementation examples for basic operations (access, search, insertion, and deletion) on different data structures: arrays, linked lists, sets, and maps.

### 1. Arrays
```java
public class ArrayOperations {
    private int[] array;

    public ArrayOperations(int size) {
        array = new int[size];
    }

    // Access
    public int access(int index) {
        return array[index];
    }

    // Search
    public int search(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Insertion (at a specific index)
    public void insert(int index, int value) {
        array[index] = value;
    }

    // Deletion (set to zero or a default value)
    public void delete(int index) {
        array[index] = 0;
    }
}
```

### 2. Linked Lists
```java
import java.util.LinkedList;

public class LinkedListOperations {
    private LinkedList<Integer> linkedList;

    public LinkedListOperations() {
        linkedList = new LinkedList<>();
    }

    // Access
    public int access(int index) {
        return linkedList.get(index);
    }

    // Search
    public boolean search(int value) {
        return linkedList.contains(value);
    }

    // Insertion
    public void insert(int value) {
        linkedList.add(value);
    }

    // Deletion
    public void delete(int value) {
        linkedList.remove(Integer.valueOf(value));
    }
}
```

### 3. Sets
```java
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    private Set<Integer> set;

    public SetOperations() {
        set = new HashSet<>();
    }

    // Insertion
    public void insert(int value) {
        set.add(value);
    }

    // Search
    public boolean search(int value) {
        return set.contains(value);
    }

    // Deletion
    public void delete(int value) {
        set.remove(value);
    }
}
```

### 4. Maps
```java
import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    private Map<Integer, String> map;

    public MapOperations() {
        map = new HashMap<>();
    }

    // Insertion
    public void insert(int key, String value) {
        map.put(key, value);
    }

    // Access
    public String access(int key) {
        return map.get(key);
    }

    // Search
    public boolean search(int key) {
        return map.containsKey(key);
    }

    // Deletion
    public void delete(int key) {
        map.remove(key);
    }
}
```

These examples demonstrate how to perform the basic operations on each data structure in Java. Each class is designed to encapsulate the operations for a specific data structure, providing methods for access, search, insertion, and deletion.

Here are Java implementation examples for basic operations (access, search, insertion, and deletion) on lists, stacks, and queues.

### 1. Lists
```java
import java.util.ArrayList;
import java.util.List;

public class ListOperations {
    private List<Integer> list;

    public ListOperations() {
        list = new ArrayList<>();
    }

    // Access
    public int access(int index) {
        return list.get(index);
    }

    // Search
    public boolean search(int value) {
        return list.contains(value);
    }

    // Insertion
    public void insert(int value) {
        list.add(value);
    }

    // Deletion
    public void delete(int value) {
        list.remove(Integer.valueOf(value));
    }
}
```

### 2. Stacks
```java
import java.util.Stack;

public class StackOperations {
    private Stack<Integer> stack;

    public StackOperations() {
        stack = new Stack<>();
    }

    // Access (Peek at the top element without removing it)
    public int access() {
        return stack.peek();
    }

    // Search (This is not a typical stack operation and requires iteration)
    public boolean search(int value) {
        return stack.contains(value);
    }

    // Insertion (Push an element onto the stack)
    public void insert(int value) {
        stack.push(value);
    }

    // Deletion (Pop the top element from the stack)
    public int delete() {
        return stack.pop();
    }
}
```

### 3. Queues
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueOperations {
    private Queue<Integer> queue;

    public QueueOperations() {
        queue = new LinkedList<>();
    }

    // Access (Peek at the front element without removing it)
    public int access() {
        return queue.peek();
    }

    // Search (This is not a typical queue operation and requires iteration)
    public boolean search(int value) {
        return queue.contains(value);
    }

    // Insertion (Add an element to the end of the queue)
    public void insert(int value) {
        queue.offer(value);
    }

    // Deletion (Remove the front element from the queue)
    public int delete() {
        return queue.poll();
    }
}
```

These examples demonstrate how to perform the basic operations on lists, stacks, and queues in Java. Each class encapsulates the operations for a specific data structure, providing methods for access, search, insertion, and deletion.