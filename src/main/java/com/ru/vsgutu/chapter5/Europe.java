package com.ru.vsgutu.chapter5;

import java.util.ArrayList;
import java.util.List;

public class Europe {
    private final List<HistoryEvent> events;

    public Europe() {
        events = new ArrayList<>();
    }

    public void addEvent(String year, String description) {
        events.add(new HistoryEvent(year, description));
    }

    public void showHistory() {
        System.out.println("История изменения территориального деления Европы:");
        for (HistoryEvent event : events) {
            System.out.println(event);
        }
    }

    public class HistoryEvent {
        private final String year;
        private final String description;

        public HistoryEvent(String year, String description) {
            this.year = year;
            this.description = description;
        }

        @Override
        public String toString() {
            return year + ": " + description;
        }
    }
}
