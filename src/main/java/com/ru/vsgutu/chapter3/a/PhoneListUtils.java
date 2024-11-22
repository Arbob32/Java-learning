package com.ru.vsgutu.chapter3.a;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneListUtils {
    public static List<Phone> getPhonesWithExcessiveLocalCallTime(
            List<Phone> phones, Duration maxLocalCallTime) {
        return phones.stream()
                .filter(p -> p.getTownCallTime().getSeconds() > maxLocalCallTime.getSeconds())
                .collect(Collectors.toList());
    }

    public static List<Phone> getPhonesWithLongDistanceCallTime(List<Phone> phones) {
        return phones.stream()
                .filter(p -> p.getLongDistanceCallTime().getSeconds() > 0)
                .collect(Collectors.toList());
    }

    public static List<Phone> getPhonesByAsc(List<Phone> phones) {
        return phones.stream()
                .sorted(Comparator.comparing(Phone::getFullName))
                .collect(Collectors.toList());
    }
}
