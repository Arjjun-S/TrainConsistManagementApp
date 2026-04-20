package com.railway;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
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
    void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Arrays.sort(bogieNames);
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, bogieNames);
    }
    @Test
    void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(bogieNames);
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, bogieNames);
    }
    @Test
    void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        Arrays.sort(bogieNames);
        String[] expected = {"AC Chair", "First Class", "General"};
        assertArrayEquals(expected, bogieNames);
    }
    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(bogieNames);
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        assertArrayEquals(expected, bogieNames);
    }
    @Test
    void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};
        Arrays.sort(bogieNames);
        String[] expected = {"Sleeper"};
        assertArrayEquals(expected, bogieNames);
    }
}
