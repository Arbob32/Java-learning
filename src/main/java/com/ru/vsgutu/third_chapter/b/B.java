package com.ru.vsgutu.third_chapter.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class B {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            double a = rand.nextInt(10) + 1;
            double b = rand.nextInt(10) + 1;
            double c = rand.nextInt(10) + 1;
            triangles.add(new Triangle(a, b, c));
        }

        List<Triangle> equilateralTriangles = TriangleListUtils.getEquilateralTriangles(triangles);
        Optional<Triangle> minAreaTriangle =
                TriangleListUtils.getTriangleWithMinArea(equilateralTriangles);
        Optional<Triangle> maxAreaTriangle =
                TriangleListUtils.getTriangleWithMaxArea(equilateralTriangles);
        System.out.printf(
                "Кол-во равносторонних треугольников: %s.\nОбъект с min S: %s.\nОбъект с max S: %s.\n",
                equilateralTriangles.size(),
                minAreaTriangle.isPresent() ? minAreaTriangle.get().toString() : "null",
                maxAreaTriangle.isPresent() ? maxAreaTriangle.get().toString() : "null");

        List<Triangle> isoscelesTriangles = TriangleListUtils.getIsoscelesTriangles(triangles);
        minAreaTriangle = TriangleListUtils.getTriangleWithMinArea(isoscelesTriangles);
        maxAreaTriangle = TriangleListUtils.getTriangleWithMaxArea(isoscelesTriangles);
        System.out.printf(
                "\nКол-во равнобедренных треугольников: %s.\nОбъект с min S: %s.\nОбъект с max S: %s.\n",
                isoscelesTriangles.size(),
                minAreaTriangle.isPresent() ? minAreaTriangle.get().toString() : "null",
                maxAreaTriangle.isPresent() ? maxAreaTriangle.get().toString() : "null");

        List<Triangle> rightTriangles = TriangleListUtils.getRightTriangleTriangles(triangles);
        minAreaTriangle = TriangleListUtils.getTriangleWithMinArea(rightTriangles);
        maxAreaTriangle = TriangleListUtils.getTriangleWithMaxArea(rightTriangles);
        System.out.printf(
                "\nКол-во прямоугольных треугольников: %s.\nОбъект с min S: %s.\nОбъект с max S: %s.\n",
                rightTriangles.size(),
                minAreaTriangle.isPresent() ? minAreaTriangle.get().toString() : "null",
                maxAreaTriangle.isPresent() ? maxAreaTriangle.get().toString() : "null");

        List<Triangle> arbitraryTriangles = TriangleListUtils.getArbitraryTriangles(triangles);
        minAreaTriangle = TriangleListUtils.getTriangleWithMinArea(arbitraryTriangles);
        maxAreaTriangle = TriangleListUtils.getTriangleWithMaxArea(arbitraryTriangles);
        System.out.printf(
                "\nКол-во произвольных треугольников: %s.\nОбъект с min S: %s.\nОбъект с max S: %s.\n",
                arbitraryTriangles.size(),
                minAreaTriangle.isPresent() ? minAreaTriangle.get().toString() : "null",
                maxAreaTriangle.isPresent() ? maxAreaTriangle.get().toString() : "null");
    }
}
