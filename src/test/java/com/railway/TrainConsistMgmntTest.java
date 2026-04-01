package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {
    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistMgmnt.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistMgmnt.validateTrainId("TRAIN12"));
        assertFalse(TrainConsistMgmnt.validateTrainId("TRN12A"));
        assertFalse(TrainConsistMgmnt.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistMgmnt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET123"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistMgmnt.validateTrainId("TRN-123"));
        assertFalse(TrainConsistMgmnt.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("pet-AB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistMgmnt.validateTrainId(""));
        assertFalse(TrainConsistMgmnt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistMgmnt.validateTrainId("TRN-1234-EXTRA"));
        assertFalse(TrainConsistMgmnt.validateCargoCode("PET-ABC"));
    }
}
