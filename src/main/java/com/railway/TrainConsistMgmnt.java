package com.railway;
import java.util.*;

public class TrainConsistMgmnt {

    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
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
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("=========================================");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed successfully...");
    }
}
