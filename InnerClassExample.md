/**
 * InnerClassExample demonstrates the use of an inner class in Java.
 * 
 * Inner classes are classes defined inside another class. They are used to
 * group classes that are logically part of the same unit.
 * 
 * @author Your Name
 */
public class InnerClassExample {

    /**
     * InnerClass is a class defined inside InnerClassExample.
     * 
     * Inner classes have access to all members of the outer class, including
     * private members.
     * 
     * @author Your Name
     */
    public class InnerClass {
        private int data;

        /**
         * Constructor for InnerClass.
         * 
         * @param data the data to be stored in the InnerClass instance
         */
        public InnerClass(int data) {
            this.data = data;
        }
        // Example of each type of inner class:

        // 1. Non-static inner class (also known as a member inner class)
        // Example: InnerClass itself is a non-static inner class
        // It can access static and non-static members of the outer class, implement
        // interfaces, define methods, fields, constructors, and inner classes.

        // 2. Static inner class
        // Example:
        public static class StaticInnerClass {
            private static int staticData;

            public static void setStaticData(int data) {
                staticData = data;
            }

            public static int getStaticData() {
                return staticData;
            }
        }
        // - Can define static members
        // - Cannot access non-static members of the outer class without an instance
        // - Can be used to implement interfaces
        // - Can be used to define methods
        // - Can be used to define fields
        // - Can be used to define constructors
        // - Can be used to define inner classes

        // 3. Local inner class
        // Example:
        public void localInnerClassExample() {
            class LocalInnerClass {
                private int localData;

                public LocalInnerClass(int data) {
                    this.localData = data;
                }

                public int getLocalData() {
                    return localData;
                }
            }
            // Usage
            LocalInnerClass localInner = new LocalInnerClass(10);
            System.out.println("Local Inner Class Data: " + localInner.getLocalData());
        }
        // - Can access static and non-static members of the outer class
        // - Can be used to implement interfaces
        // - Can be used to define methods
        // - Can be used to define fields
        // - Can be used to define constructors
        // - Can be used to define inner classes

        // 4. Anonymous inner class
        // Example:
        public void anonymousInnerClassExample() {
            // Anonymous inner class implementing an interface
            Runnable anonymousInner = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Anonymous Inner Class Example");
                }
            };
            // Usage
            anonymousInner.run();

}
// - Can access static and non-static me
// - Can be used to implement inte
// - Can be used to define method
// - Can be used to define fields
// - Can be used to define constructors
