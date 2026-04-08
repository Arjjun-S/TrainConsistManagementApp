package com.railway;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmnt {

    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "[" + name + " | Cap: " + capacity + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC9 - Group Bogies by Type (groupingBy) ");
        System.out.println("=========================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72)); // Duplicate type for grouping
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("AC Chair", 56));

        // UC9: Grouping logic using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogie Report:");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + ": " + list);
        });

        System.out.println("\nUC9 grouping completed successfully...");
    }
}
