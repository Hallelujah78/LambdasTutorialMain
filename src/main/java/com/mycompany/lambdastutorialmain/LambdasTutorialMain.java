/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lambdastutorialmain;

/**
 * Lambdas: https://chatgpt.com/c/67d0623c-fa10-8006-a01a-1baf6310e173
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

        Printable lambdaPrint = (s) -> {
            System.out.println("Meow!" + s);
            return s; // Return some string.
        };
        printThing(lambdaPrint); // Prints Meow!!

    }
}
