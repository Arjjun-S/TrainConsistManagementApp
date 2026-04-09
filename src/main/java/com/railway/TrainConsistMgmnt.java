package com.railway;

public class TrainConsistMgmnt {
    public static boolean searchWithValidation(String[] bogieIds, String target) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }
        for (String id : bogieIds) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("=========================================");
        String[] bogieIds = {};
        String searchId = "BG101";
        try {
            boolean found = searchWithValidation(bogieIds, searchId);
            System.out.println("Bogie found: " + found);
        } catch (IllegalStateException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        System.out.println("\nUC20 execution completed...");
    }
}
