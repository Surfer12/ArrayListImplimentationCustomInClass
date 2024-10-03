Homework

Upload arraylist with implimentation of the given functions
    Specifically analyze the clear function.

Explore the implementation of queue and stack data structures using arrays in Java.

Queue Implementation:
```java
public class Queue {
    private int front, rear, size;
    private int capacity;
    private int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Queue is full when size becomes equal to the capacity
    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    // Queue is empty when size is 0
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    // Method to remove an item from queue.
    // It changes front and size
    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get front of queue
    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    // Method to get rear of queue
    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}
```

Stack Implementation:
```java
public class Stack {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }
    Stack() {
        top = -1;
    }

    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }
}
```

    // Example of using anonymous inner classes to override methods in Java
    // This example demonstrates how to use an anonymous inner class to override the toString() method of the Object class.
    // The anonymous inner class is used to create an instance of a class that overrides the toString() method.
    // This approach is particularly useful when you need to create a one-time use object that requires a specific implementation of a method.
    // In this case, we're creating an object that returns a custom string representation when the toString() method is called.
    // Define an interface with a method to be overridden
```java
    interface CustomToString {
        String customToString();
    }

    // Create an instance of an anonymous inner class that implements the CustomToString interface
    CustomToString customToStringInstance = new CustomToString() {
        @Override
        public String customToString() {
            return "This is a custom string representation.";
        }
    };

// Use the customToStringInstance to call the overridden method
System.out.println(customToStringInstance.customToString());
```