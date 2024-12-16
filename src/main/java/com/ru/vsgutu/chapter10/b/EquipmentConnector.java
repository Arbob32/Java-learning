package com.ru.vsgutu.chapter10.b;

import com.ru.vsgutu.chapter4.b.equipment.Equipment;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EquipmentConnector {
    public static void saveEquipmentList(List<Equipment> equipmentList, String filename)
            throws IOException {
        try (ObjectOutputStream out =
                new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            out.writeObject(equipmentList);
        }
    }

    public static List<Equipment> loadEquipmentList(String filename)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream in =
                new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return (List<Equipment>) in.readObject();
        }
    }
}
