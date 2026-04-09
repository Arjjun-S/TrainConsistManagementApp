package com.railway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistMgmnt.binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistMgmnt.binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistMgmnt.binarySearch(bogieIds, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        assertFalse(TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // The binarySearch method handles sorting internally
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(TrainConsistMgmnt.binarySearch(bogieIds, "BG205"));
    }
}
