package com.railway;

public class TrainConsistMgmnt {

    // UC16: Bubble Sort Method for manual sorting
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap logic
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("=========================================");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) System.out.print(c + " ");

        // Perform manual sorting
        bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) System.out.print(c + " ");

        System.out.println("\n\nUC16 sorting completed successfully...");
    }
}
