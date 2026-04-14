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
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }
    static class GoodsBogie {
        String shape;
        String cargo = "None";

        GoodsBogie(String shape) {
            this.shape = shape;
        }
        void assignCargo(String cargo) {
            try {
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC15 - Safe Cargo Assignment (try-catch-finally) ");
        System.out.println("=========================================");
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum");
        System.out.println();
        GoodsBogie g2 = new GoodsBogie("Rectangular");
        g2.assignCargo("Petroleum");
        System.out.println("\nUC15 runtime handling completed successfully...");
    }
}
