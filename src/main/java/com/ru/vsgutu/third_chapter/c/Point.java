package com.ru.vsgutu.third_chapter.c;

public class Point {
    private final Rational x;
    private final Rational y;
    private final Rational z;

    public Point(Rational x, Rational y, Rational z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistanceTo(Point p) {
        Rational dx = p.x.subtract(this.x);
        Rational dy = p.y.subtract(this.y);
        Rational dz = p.z.subtract(this.z);

        double distanceSquared =
                Math.pow(dx.toDouble(), 2)
                        + Math.pow(dy.toDouble(), 2)
                        + Math.pow(dz.toDouble(), 2);
        return Math.sqrt(distanceSquared);
    }

    public double getDistanceToOrigin() {
        return getDistanceTo(new Point(new Rational(0, 0), new Rational(0, 0), new Rational(0, 0)));
    }

    public static boolean areCollinear(Point p1, Point p2, Point p3) {
        // Вектор p1p2
        Rational dx1 = p2.x.subtract(p1.x);
        Rational dy1 = p2.y.subtract(p1.y);
        Rational dz1 = p2.z.subtract(p1.z);

        // Вектор p2p3
        Rational dx2 = p3.x.subtract(p2.x);
        Rational dy2 = p3.y.subtract(p2.y);
        Rational dz2 = p3.z.subtract(p2.z);

        // Векторное произведение p1p2 и p2p3
        Rational crossProductX = dy1.multiply(dz2).subtract(dz1.multiply(dy2));
        Rational crossProductY = dz1.multiply(dx2).subtract(dx1.multiply(dz2));
        Rational crossProductZ = dx1.multiply(dy2).subtract(dy1.multiply(dx2));
        return crossProductX.equals(new Rational(0, 0))
                && crossProductY.equals(new Rational(0, 0))
                && crossProductZ.equals(new Rational(0, 0));
    }
}
