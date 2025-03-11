/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lambdastutorialmain;

/**
 *
 * @author gavan
 */
public class LambdasTutorialMain {

    static void printThing(Printable thing) {
        thing.print("!");
    }

    public static void main(String[] args) {

        var cat = new Cat();
        cat.print("hi");

        printThing(cat);

        Printable lambdaPrint = (s) -> System.out.println("Meow!" + s);
        printThing(lambdaPrint); // Prints Meow!!

    }
}
