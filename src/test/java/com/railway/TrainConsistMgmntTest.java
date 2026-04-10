package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistMgmntTest {

    private boolean checkSafety(List<TrainConsistMgmnt.GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistMgmnt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmnt.GoodsBogie("Open", "Coal")
        );
        assertTrue(checkSafety(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistMgmnt.GoodsBogie> bogies = Collections.singletonList(
                new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(checkSafety(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistMgmnt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmnt.GoodsBogie("Open", "Coal"),
                new TrainConsistMgmnt.GoodsBogie("Box", "Grain")
        );
        assertTrue(checkSafety(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistMgmnt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmnt.GoodsBogie("Cylindrical", "Chemicals") // Violation
        );
        assertFalse(checkSafety(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        // allMatch on an empty stream is vacuously true
        assertTrue(checkSafety(bogies));
    }
}
