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

## https://youtu.be/tj5sLSFjVj4?t=514
