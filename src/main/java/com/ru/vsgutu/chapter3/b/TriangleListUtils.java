package com.ru.vsgutu.chapter3.b;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TriangleListUtils {
    public static List<Triangle> getArbitraryTriangles(List<Triangle> triangles) {
        return triangles.stream().filter(Triangle::isArbitary).collect(Collectors.toList());
    }

    public static List<Triangle> getEquilateralTriangles(List<Triangle> triangles) {
        return triangles.stream().filter(Triangle::isEquilateral).collect(Collectors.toList());
    }

    public static List<Triangle> getIsoscelesTriangles(List<Triangle> triangles) {
        return triangles.stream().filter(Triangle::isIsosceles).collect(Collectors.toList());
    }

    public static List<Triangle> getRightTriangleTriangles(List<Triangle> triangles) {
        return triangles.stream().filter(Triangle::isRight).collect(Collectors.toList());
    }

    public static Optional<Triangle> getTriangleWithMaxArea(List<Triangle> triangles) {
        return triangles.stream().max(Comparator.comparingDouble(Triangle::getArea));
    }

    public static Optional<Triangle> getTriangleWithMinArea(List<Triangle> triangles) {
        return triangles.stream().min(Comparator.comparingDouble(Triangle::getArea));
    }
}
