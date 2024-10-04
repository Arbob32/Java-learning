package com.ru.vsgutu.third_chapter.b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.ru.vsgutu.third_chapter.b.Triangle;

public class TriangleList {
    List<Triangle> triangles;

    public TriangleList() {
        triangles = new ArrayList<>();
    }

    public long getEquilateralCount() {
        return triangles.stream().filter((t) -> t.getA() == t.getB() && t.getB() == t.getC()).count();
    }

    public long getIsoscelesCount() {
        return triangles.stream().filter((t) -> (t.getA() == t.getB() && t.getB() != t.getC()) || (t.getA() == t.getC() && t.getB() != t.getC())).count();
    }

    public long getRightTriangleCount() {
        return triangles.stream().filter(t -> Math.pow(t.getA(), 2) + Math.pow(t.getB(), 2) == Math.pow(t.getC(), 2) ||
                                                    Math.pow(t.getB(), 2) + Math.pow(t.getC(), 2) == Math.pow(t.getA(), 2) ||
                                                    Math.pow(t.getC(), 2) + Math.pow(t.getA(), 2) == Math.pow(t.getB(), 2)).count();
    }

    public long getArbitraryTriangleCount() {
        return triangles.stream().filter(t -> t.getA() != t.getB() && t.getB() != t.getC() && t.getA() != t.getC()).count();
    }
}
