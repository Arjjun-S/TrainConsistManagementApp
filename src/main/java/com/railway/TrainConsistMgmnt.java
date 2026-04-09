package com.railway;
public class TrainConsistMgmnt {
    public static boolean linearSearch(String[] bogieIds, String target) {
        for (String id : bogieIds) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=========================================");
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        boolean found = linearSearch(bogieIds, searchId);
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " not found.");
        }
        System.out.println("\nUC18 search completed successfully...");
    }
}
