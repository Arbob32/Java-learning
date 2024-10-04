package com.ru.vsgutu.third_chapter.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneList {
    private List<Phone> phones;

    public PhoneList() {
        this.phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public List<Phone> getPhonesWithExcessiveLocalCallTime(Duration maxLocalCallTime) {
        return phones.stream()
                .filter(p -> p.getTownCallTime() > maxLocalCallTime)
                .collect(Collectors.toList());
    }

    public List<Phone> getPhonesWithLongDistanceCallTime() {
        return phones.stream()
                .filter(p -> p.getLongDistanceCallTime().getSeconds() > 0)
                .collect(Collectors.toList());
    }

    public List<Phone> getPhonesByAsc() {
        return phones.stream().sorted(Comparator.comparing(p -> p.getFullName()));
    }
}
