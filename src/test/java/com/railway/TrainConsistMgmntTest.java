package com.railway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {
    @Test
    void testException_ValidCapacityCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie bogie = new TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.capacity);
    }
    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmnt.PassengerBogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmnt.PassengerBogie("General", 0);
        });
    }
    @Test
    void testException_ExceptionMessageValidation() {
        TrainConsistMgmnt.InvalidCapacityException exception = assertThrows(
                TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new TrainConsistMgmnt.PassengerBogie("First Class", -5)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie bogie = new TrainConsistMgmnt.PassengerBogie("AC Chair", 56);
        assertEquals("AC Chair", bogie.type);
        assertEquals(56, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistMgmnt.InvalidCapacityException {
        TrainConsistMgmnt.PassengerBogie b1 = new TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        TrainConsistMgmnt.PassengerBogie b2 = new TrainConsistMgmnt.PassengerBogie("First Class", 24);
        assertNotSame(b1, b2);
    }

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistMgmnt.GoodsBogie bogie = new TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistMgmnt.GoodsBogie bogie = new TrainConsistMgmnt.GoodsBogie("Rectangular");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistMgmnt.GoodsBogie bogie = new TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertEquals("None", bogie.cargo, "Cargo should remain 'None' on failure");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistMgmnt.GoodsBogie bogie = new TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        bogie.assignCargo("Grain");
        assertEquals("Grain", bogie.cargo, "Program should continue to process valid assignments");
    }

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{40, 40, 40}, capacities);
    }
}
