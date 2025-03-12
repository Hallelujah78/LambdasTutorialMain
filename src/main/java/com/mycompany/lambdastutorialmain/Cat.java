/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lambdastutorialmain;

/**
 *
 * @author gavan
 */
public class Cat implements Printable {

    public String name;

    public int age;

    @Override
    public String print(String suffix) {
        System.out.println("Implements print from Printable");
        return suffix;
    }

}
