package com.ru.vsgutu.chapter1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreditsDisplayer {
    public static void display() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm");
        String formattedDateTime = now.format(formatter);
        System.out.println(
                "Разработчик: Мясников Артём\n"
                        + "Дата и время получения задания: 7.09.2024 14:00\n"
                        + "Дата и время сдачи задания: "
                        + formattedDateTime);
    }
}
