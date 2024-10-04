package com.ru.vsgutu.third_chapter.a;

import java.time.Duration;
import java.util.List;

public class A {
    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();
        phoneList.addPhone(new Phone(1,
                "Артём",
                "Мясников",
                "Андреевич",
                12332112332L,
                123,
                321,
                Duration.ofSeconds(123),
                Duration.ofSeconds(321)));

        phoneList.addPhone(new Phone(2,
                "Петр",
                "Петров",
                "Петрович",
                12332112332L));

        phoneList.addPhone(new Phone(3,
                "Александр",
                "Александров",
                "Александрович",
                12332112332L,
                130,
                230,
                Duration.ofSeconds(2),
                Duration.ofSeconds(5)));

        phoneList.addPhone(new Phone(4,
                "Михаил",
                "Михаилов",
                "Михаилович",
                12332112332L,
                200,
                150,
                Duration.ofSeconds(123),
                Duration.ofSeconds(321)));

        phoneList.addPhone(new Phone(5,
                "Алексей",
                "Алексеев",
                "Алексеевич",
                12332112332L,
                100,
                100,
                Duration.ofSeconds(88),
                Duration.ofSeconds(11)));

        System.out.println("Абоненты в порядке алфавитной сортировки по ФИО\n");
        for (Phone phone : phoneList.getPhonesByAsc()) {
            System.out.println(phone.getFullName());
        }

        System.out.println("\nАбоненты со временем городских звонков > 120 секунд\n");
        for (Phone phone : phoneList.getPhonesWithExcessiveLocalCallTime(Duration.ofSeconds(120))) {
            System.out.println(phone.toString());
        }

        System.out.println("\nАбоненты со временем междугородних звонков\n");
        for (Phone phone : phoneList.getPhonesWithLongDistanceCallTime()) {
            System.out.println(phone.toString());
        }
    }




}
