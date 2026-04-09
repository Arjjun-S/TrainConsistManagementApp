package com.railway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {

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
}
