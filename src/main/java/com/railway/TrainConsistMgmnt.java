package com.railway;
import java.util.*;

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
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC10 - Count Total Seats in Train (reduce) ");
        System.out.println("=========================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("\nBogies in Train:");
        bogies.forEach(System.out::println);

        // UC10: map to extract capacities and reduce to sum them
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);
        System.out.println("\nUC10 aggregation completed successfully...");
    }
}