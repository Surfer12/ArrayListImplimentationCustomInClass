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

```java
// Example of an anonymous inner class that extends a class

abstract class Animal {
    abstract void makeSound();
}

public class AnonymousInnerClassExample2 {
    public void display() {
        Animal dog = new Animal() {
            void makeSound() {
                System.out.println("Woof Woof!");
            }
        };
        dog.makeSound();
    }

    public static void main(String[] args) {
        AnonymousInnerClassExample2 aice2 = new AnonymousInnerClassExample2();
        aice2.display();
    }
}
```

```java
// Example of an anonymous inner class used in a method argument

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousInnerClassExample3 {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Orange", "Banana", "Pineapple"};

        Arrays.sort(fruits, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

```java
// Example of an anonymous inner class used in a thread

public class AnonymousInnerClassExample4 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread is running");
            }
        });

        thread.start();
    }
}
```

