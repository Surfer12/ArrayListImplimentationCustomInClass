# Anonymous Inner Classes in java 

    - Anonymous inner classes are defined without a class name. They are used to
implement interfaces or extend classes without explicitly declaring a new
class. They are useful when you need to create a new instance of an interface or
class at runtime.   

```java  // Example of an anonymous inner class that implements an interface

interface HelloWorld {
    void greet();
}

public class AnonymousInnerClassExample {
    public void display() {
        HelloWorld hw = new HelloWorld() {
            public void greet() {
                System.out.println("Hello World!");
            }
        };
        hw.greet();
    }

    public static void main(String[] args) {
        AnonymousInnerClassExample aice = new AnonymousInnerClassExample();
        aice.display();
    }
}
```

