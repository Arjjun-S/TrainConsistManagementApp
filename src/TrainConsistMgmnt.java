import java.util.*;
public class TrainConsistMgmnt {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   === Train Consist Management App ===   ");
        System.out.println("==========================================");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Inital Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);

        System.out.println("\nSystem ready for operations...");

        System.out.println("========================================");
        System.out.println("   UC2: Add Passenger Bogies to Train   ");
        System.out.println("========================================");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nAfter adding Bogies: ");
        System.out.println("Passenger Bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair': ");
        System.out.println("Passenger Bogies: " + passengerBogies);

        System.out.println("\nChecking if 'Sleeper' exists: ");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist: ");
        System.out.println(passengerBogies);

        System.out.println("\nCRUD operations(UC2) completed successfully...");

        System.out.println("=======================================");
        System.out.println("      UC3: Track Unique Bogie IDs      ");
        System.out.println("=======================================");

        Set<String> bogies = new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion: ");
        System.out.println(bogies);

        System.out.println("\nNote:\nDuplicates are automatically ignored by the HashSet.\n");

        System.out.println("Uniqueness validation completed... (UC3)");


    }
}