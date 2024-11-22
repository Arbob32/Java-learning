package com.ru.vsgutu.chapter3.b;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public boolean isArbitary() {
        return this.getA() != this.getB()
                && this.getB() != this.getC()
                && this.getA() != this.getC();
    }

    public boolean isEquilateral() {
        return this.getA() == this.getB() && this.getB() == this.getC();
    }

    public boolean isIsosceles() {
        return (this.getA() == this.getB() && this.getB() != this.getC())
                || (this.getA() == this.getC() && this.getB() != this.getC());
    }

    public boolean isRight() {
        return Math.pow(this.getA(), 2) + Math.pow(this.getB(), 2) == Math.pow(this.getC(), 2)
                || Math.pow(this.getB(), 2) + Math.pow(this.getC(), 2) == Math.pow(this.getA(), 2)
                || Math.pow(this.getC(), 2) + Math.pow(this.getA(), 2) == Math.pow(this.getB(), 2);
    }

    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
}
