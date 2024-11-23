package com.ru.vsgutu.chapter3.c;

import com.ru.vsgutu.chapter1.CreditsDisplayer;

// Мясников А. Б762-2 7 ВАРИАНТ
public class C {
    public static void main(String[] args) {
        CreditsDisplayer.display();
        Rational x1 = new Rational(1, 1);
        Rational y1 = new Rational(1, 2);
        Rational z1 = new Rational(1, 5);

        Rational x2 = new Rational(2, 1);
        Rational y2 = new Rational(4, 1);
        Rational z2 = new Rational(6, 1);

        Rational x3 = new Rational(3, 1);
        Rational y3 = new Rational(6, 1);
        Rational z3 = new Rational(9, 1);

        Point p1 = new Point(x1, y1, z1);
        Point p2 = new Point(x2, y2, z2);
        Point p3 = new Point(x3, y3, z3);

        System.out.println("Расстояние от p1 до p2: " + p1.getDistanceTo(p2));
        System.out.println("Расстояние от p1 до начала координат: " + p1.getDistanceToOrigin());

        if (Point.areCollinear(p1, p2, p3)) {
            System.out.println("Точки коллинеарны.");
        } else {
            System.out.println("Точки не коллинеарны.");
        }
    }
}
