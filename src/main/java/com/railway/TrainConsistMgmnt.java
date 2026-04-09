package com.railway;

import java.util.Arrays;

public class TrainConsistMgmnt {
    public static boolean binarySearch(String[] bogieIds, String key) {
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = key.compareTo(bogieIds[mid]);
            if (result == 0) {
                return true;
            }
            if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=========================================");
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String key = "BG309";
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        boolean found = binarySearch(bogieIds, key);
        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " not found.");
        }
        System.out.println("\nUC19 search completed successfully...");
    }
}
