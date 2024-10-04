package com.ru.vsgutu.third_chapter.b;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TriangleListUtils {
    public static List<Triangle> getArbitraryTriangles(List<Triangle> triangles) {
        return triangles.stream()
                .filter(t -> t.getA() != t.getB() && t.getB() != t.getC() && t.getA() != t.getC())
                .collect(Collectors.toList());
    }

    public static List<Triangle> getEquilateralTriangles(List<Triangle> triangles) {
        return triangles.stream()
                .filter(t -> t.getA() == t.getB() && t.getB() == t.getC())
                .collect(Collectors.toList());
    }

    public static List<Triangle> getIsoscelesTriangles(List<Triangle> triangles) {
        return triangles.stream()
                .filter(
                        t ->
                                (t.getA() == t.getB() && t.getB() != t.getC())
                                        || (t.getA() == t.getC() && t.getB() != t.getC()))
                .collect(Collectors.toList());
    }

    public static List<Triangle> getRightTriangleTriangles(List<Triangle> triangles) {
        return triangles.stream()
                .filter(
                        t ->
                                Math.pow(t.getA(), 2) + Math.pow(t.getB(), 2)
                                                == Math.pow(t.getC(), 2)
                                        || Math.pow(t.getB(), 2) + Math.pow(t.getC(), 2)
                                                == Math.pow(t.getA(), 2)
                                        || Math.pow(t.getC(), 2) + Math.pow(t.getA(), 2)
                                                == Math.pow(t.getB(), 2))
                .collect(Collectors.toList());
    }

    public static Optional<Triangle> getTriangleWithMaxArea(List<Triangle> triangles) {
        return triangles.stream().max(Comparator.comparingDouble(Triangle::getArea));
    }

    public static Optional<Triangle> getTriangleWithMinArea(List<Triangle> triangles) {
        return triangles.stream().min(Comparator.comparingDouble(Triangle::getArea));
    }
}
