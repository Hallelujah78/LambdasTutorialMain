# LambdasTutorialMain

Lambdas tutorial: https://www.youtube.com/watch?v=tj5sLSFjVj4

- Can only be used with certain types of interfaces

# Interfaces

- A contract that states any class implementing the interface must provide own implementations of methods of the interface.
- A Printable interface:

```java
	interface Printable {

    // Interface method with no implementation.
    public void print();
}
```

- we can have a Cat class that implements Printable: `cat.print()`
- we can have a method that accepts an object of type Printable:

```java
static void printThing(Printable thing) {
        thing.print();
    }
```

- and so:

```java
printThing(cat); // calls cat.print()
```

- Since Cat implements the print method of Printable and `printThing` accepts a `Printable` type, we are guaranteed that we can call `print` on the parameter `thing` - which is any type that implements Printable interface

# Lambdas

- Only thing you can do with a Printable type is to call `print` on it
- in `printThing` we only care about the implementation of `print` that the `thing` param provides
- in order to call `thing.print` we have to worry about:
  - Have a class implement Printable (Cat)
  - Provide an implementation of the `print` method
  - Create an object of class Cat and pass it to `printThing`
- Lambdas allow us to pass in an implementation of the `print` method as the `Printable` parameter
- example Lambda structure:

```java
() -> {
    // Do stuff here
}
```

- Instead of passing in an object (Cat) that contains an action (`print`), we just send in the action itself
- Simplifying if only one expression, similar to JavaScript arrow func:

```java
printThing(() -> System.out.println("Meow!"));
```

- We can also save our Lambda as a variable:

```java
Printable lambdaPrint = () -> System.out.println("Meow!");
printThing(lambdaPrint);
```

- Lambdas allow us to save a method implementation as an object and store them in variables

# Lambdas and Parameters

- imagine `print` took a parameter

```java
 // Interface method with no implementation.
    public void print(String suffix);
```

- update `printThing`:

```java
 static void printThing(Printable thing) {
        thing.print("!");
    }
```

- Use the parameter with `lambdaPrint`:

```java
Printable lambdaPrint = (s) -> System.out.println("Meow!" + s);
        printThing(lambdaPrint); // Prints Meow!!
```

- Can use multiple parameters
- Can omit paretheses where there is only one param:

```java
Printable lambdaPrint = (s) -> System.out.println("Meow!" + s);
```

# What if interface method has a return type?

- image Printable.print returns a String

```java
// Interface method with no implementation.
    public String print(String suffix);
```

- We can update the lambdaPrint (and Cat print ofc), multiline:

```java
 Printable lambdaPrint = (s) -> {
            System.out.println("Meow!" + s);
            return s; // Return some string.
        };
```

- Single expression:

```java
Printable lambdaPrint = (s) -> "Meow " + s;
```

# How Lambdas Work - Behind the Scenes

- going back to Printable interface
  - We have one method `print` in the Printable interface
  - A method with no implementation is abstract
    - Interface with exactly one abstract method is a Functional Inteface
    - can add annotation at top of interface (don't have to add it but good practice):

```java
@FunctionalInterface
public interface Printable {}
```

- Compiler will enforce that you have exactly one abstract method in the interface using annotation.
- AKA SAM interface - Single Abstract Method
- `Printable` could contain static or default methods and still be a SAM interface
  - must have exactly one abstract method
- What does this have to do with Lambdas?
  - Lambdas can only be used in the context of a functional interface
  - if interface has more than one abstract method, CANNOT use lambda for it
  - Can test by:
    - remove annotation from Printable
    - add another method and save
    - will get IDE warning for our lambdaPrint:

```java
incompatible types: Printable is not a functional interface
    multiple non-overriding abstract methods found in interface Printable
```

- Can only define implementation of 1 method in a lambda
  - when the interface has more than one, Java doesn't know which method the lambda is providing the implementation for!
- You can achieve similar results with an interface with more than one abstract method using an `Anonymous Class`
- technically, lambda is a shortcut to defining an implementation of a functional interface
  - we can skip creating a class that implements the functional interface (Cat)
  - we can skip creating an object of the class (Cat)
  - simply create lambda expression that contains the implementation of the functional interface method
  - Lets you treat code as a parameter
