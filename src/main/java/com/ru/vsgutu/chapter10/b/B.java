package com.ru.vsgutu.chapter10.b;

import com.ru.vsgutu.chapter4.b.equipment.Equipment;
import com.ru.vsgutu.chapter4.b.equipment.Gloves;
import com.ru.vsgutu.chapter4.b.equipment.Helmet;
import com.ru.vsgutu.chapter4.b.equipment.Jacket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {

    public static void start(String filename) {
        List<Equipment> equipmentList = new ArrayList<>();

        try {
            equipmentList = EquipmentConnector.loadEquipmentList(filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке списка" + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить элемент экипировки");
            System.out.println("2. Посчитать стоимость экипировки");
            System.out.println("3. Отсортировать экипировку по весу");
            System.out.println("4. Найти элементы экипировки в заданном диапазоне цены");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEquipment(equipmentList, scanner);
                    break;
                case 2:
                    calculateTotalPrice(equipmentList);
                    break;
                case 3:
                    sortEquipmentByWeight(equipmentList);
                    break;
                case 4:
                    findEquipmentInPriceRange(equipmentList, scanner);
                    break;
                case 5:
                    try {
                        EquipmentConnector.saveEquipmentList(equipmentList, filename);
                    } catch (IOException e) {
                        System.out.println("ошибка сохранения списка" + e.getMessage());
                    }
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

    private static void addEquipment(List<Equipment> equipmentList, Scanner scanner) {
        System.out.println("Введите тип экипировки (1 - Перчатки, 2 - Куртка, 3 - Шлем):");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите название:");
        String name = scanner.nextLine();
        System.out.println("Введите цену:");
        double price = scanner.nextDouble();
        System.out.println("Введите вес:");
        double weight = scanner.nextDouble();

        Equipment newEquipment;
        switch (type) {
            case 1:
                newEquipment = new Gloves(name, price, weight);
                break;
            case 2:
                newEquipment = new Jacket(name, price, weight);
                break;
            case 3:
                newEquipment = new Helmet(name, price, weight);
                break;
            default:
                System.out.println("Некорректный тип экипировки");
                return;
        }

        equipmentList.add(newEquipment);
        System.out.println("Элемент экипировки добавлен");
    }

    private static void calculateTotalPrice(List<Equipment> equipmentList) {
        double totalPrice = equipmentList.stream().mapToDouble(Equipment::getPrice).sum();
        System.out.println("Общая стоимость экипировки: " + totalPrice + " руб.");
    }

    private static void sortEquipmentByWeight(List<Equipment> equipmentList) {
        List<Equipment> sortedEquipment =
                equipmentList.stream()
                        .sorted(Comparator.comparingDouble(Equipment::getWeight))
                        .collect(Collectors.toList());
        System.out.println("Экипировка отсортирована по весу:");
        sortedEquipment.forEach(System.out::println);
    }

    private static void findEquipmentInPriceRange(List<Equipment> equipmentList, Scanner scanner) {
        System.out.println("Введите минимальную цену:");
        double minPrice = scanner.nextDouble();
        System.out.println("Введите максимальную цену:");
        double maxPrice = scanner.nextDouble();

        List<Equipment> filteredEquipment =
                equipmentList.stream()
                        .filter(
                                equipment ->
                                        equipment.getPrice() >= minPrice
                                                && equipment.getPrice() <= maxPrice)
                        .collect(Collectors.toList());
        System.out.println("Элементы экипировки в заданном диапазоне цены:");
        filteredEquipment.forEach(System.out::println);
    }
}
