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
            return name + " (Capacity: " + capacity + ")";
        }
    }
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC8 - Filter Passenger Bogies (Streams) ");
        System.out.println("=========================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);
        int threshold = 60;
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
        System.out.println("\nHigh Capacity Bogies ( > " + threshold + " ):");
        highCapacityBogies.forEach(System.out::println);
        System.out.println("\nUC8 filtering completed successfully...");
    }
}
