package com.railway;

public class TrainConsistMgmnt {
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }
    static class PassengerBogie {
        String type;
        int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Seats: " + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("=========================================");

        try {
            System.out.println("Attempting to create a valid bogie...");
            PassengerBogie s1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + s1);

            System.out.println("\nAttempting to create an invalid bogie (Capacity: -10)...");
            PassengerBogie s2 = new PassengerBogie("AC Chair", -10);

        } catch (InvalidCapacityException e) {
            System.err.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("\nUC14 capacity validation completed ...");
    }
}
