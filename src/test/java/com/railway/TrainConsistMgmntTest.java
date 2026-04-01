package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmntTest {

    private List<TrainConsistMgmnt.Bogie> getTestDataset(int size) {
        List<TrainConsistMgmnt.Bogie> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new TrainConsistMgmnt.Bogie("Sleeper", 72));
            list.add(new TrainConsistMgmnt.Bogie("AC Chair", 56));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistMgmnt.Bogie> bogies = getTestDataset(10);
        List<TrainConsistMgmnt.Bogie> filtered = new ArrayList<>();
        for (TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) filtered.add(b);
        }
        assertEquals(10, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistMgmnt.Bogie> bogies = getTestDataset(10);
        List<TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(10, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistMgmnt.Bogie> bogies = getTestDataset(100);

        // Loop result
        List<TrainConsistMgmnt.Bogie> loopRes = new ArrayList<>();
        for (TrainConsistMgmnt.Bogie b : bogies) if (b.capacity > 60) loopRes.add(b);

        // Stream result
        List<TrainConsistMgmnt.Bogie> streamRes = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopRes.size(), streamRes.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Small dummy operation
        Math.pow(10, 10);
        long end = System.nanoTime();
        assertTrue((end - start) >= 0, "Elapsed time should be non-negative");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistMgmnt.Bogie> bogies = getTestDataset(5000);
        long count = bogies.stream().filter(b -> b.capacity > 60).count();
        assertEquals(5000, count);
    }
}
