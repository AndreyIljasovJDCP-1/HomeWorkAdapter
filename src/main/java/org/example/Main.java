package org.example;

import org.example.calculations.Ints;
import org.example.calculations.IntsCalculator;

public class Main {
    public static void main(String[] args) {

        Ints calc = new IntsCalculator();
        System.out.println(calc.mult(5,5));
        System.out.println(calc.sum(5,5));
        System.out.println(calc.pow(-10,2));
        System.out.println(calc.div(25,6));
    }
}