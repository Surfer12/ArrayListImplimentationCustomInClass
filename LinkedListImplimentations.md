Understand implimenting single versus double pointers for the implimenting of linked lists in java

i.e a stack implimented using a linked list

a queue implimented using a linked list

an array list implimented using a linked list

an array implimented using a linked list
// Stack implemented using a linked list
```java
class Stack {
    private Node top;

    private class Node {
        int data;
        Node next;
    }

    public Stack() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack is empty");
        int data = top.data;
        top = top.next;
        return data;
    }
}

// Queue implemented using a linked list
class Queue {
    private Node front, rear;

    private class Node {
        int data;
        Node next;
    }

    public Queue() {
        front = rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
}

// ArrayList implemented using a linked list
class ArrayList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;
    }

    public ArrayList() {
        head = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }
}

// Array implemented using a linked list
class LinkedListArray {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;
    }

    public LinkedListArray(int size) {
        this.size = size;
        head = new Node();
        Node current = head;
        for (int i = 1; i < size; i++) {
            current.next = new Node();
            current = current.next;
        }
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
```