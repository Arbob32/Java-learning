package com.ru.vsgutu.third_chapter.c;

public class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rational(num, den);
    }

    public Rational subtract(Rational other) {
        if (other.numerator == 0) {
            return new Rational(this.numerator, this.denominator);
        } else if (this.numerator == 0) {
            return new Rational(-other.numerator, -other.denominator);
        }

        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rational(num, den);
    }

    public Rational multiply(Rational other) {
        return new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }
}
