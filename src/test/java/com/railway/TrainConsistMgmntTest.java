package com.railway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        // Verifies that the exception is thrown when array is empty
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            TrainConsistMgmnt.searchWithValidation(bogieIds, "BG101");
        });
        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        // Should execute without throwing an exception
        assertDoesNotThrow(() -> TrainConsistMgmnt.searchWithValidation(bogieIds, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistMgmnt.searchWithValidation(bogieIds, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(TrainConsistMgmnt.searchWithValidation(bogieIds, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        assertTrue(TrainConsistMgmnt.searchWithValidation(bogieIds, "BG101"));
    }
}
