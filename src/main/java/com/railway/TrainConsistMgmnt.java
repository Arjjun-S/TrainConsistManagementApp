package com.railway;
import java.util.*;

public class TrainConsistMgmnt {

    static class GoodsBogie {
        String type;
        String cargo;
        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("=======================================");
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // Rule violation
        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);
        boolean isSafe = goodsBogies.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true;
        });
        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println("\nUC12 safety validation completed ...");
    }
}
