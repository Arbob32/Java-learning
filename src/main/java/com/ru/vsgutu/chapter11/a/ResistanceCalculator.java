package com.ru.vsgutu.chapter11.a;

import java.util.List;
import java.util.stream.IntStream;

// Списки, стеки или очереди T(1..n) и U(1..n) содержат результаты n-измере-
// ний тока и напряжения на неизвестном сопротивлении R. Найти прибли-
// женное число R методом наименьших квадратов
public class ResistanceCalculator {
    public static double calculateResistance(List<Double> currents, List<Double> voltages) {
        double sumTU =
                IntStream.range(0, currents.size())
                        .mapToDouble(i -> currents.get(i) * voltages.get(i))
                        .sum();

        double sumT2 = currents.stream().mapToDouble(t -> t * t).sum();

        return sumTU / sumT2;
    }
}
