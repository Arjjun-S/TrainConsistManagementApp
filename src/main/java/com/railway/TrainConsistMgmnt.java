package com.railway;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistMgmnt {
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";
    public static boolean validateTrainId(String trainId) {
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }
    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code");
        System.out.println("=======================================");
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();
        boolean isTrainIdValid = validateTrainId(trainId);
        boolean isCargoCodeValid = validateCargoCode(cargoCode);
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);
        if (isTrainIdValid && isCargoCodeValid) {
            System.out.println("\nUC11 validation completed successfully...");
        } else {
            System.out.println("\nUC11 validation failed: Please check input formats.");
        }
        scanner.close();
    }
}
