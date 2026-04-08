package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistMgmntTest {
    private List<TrainConsistMgmnt.Bogie> getMockBogies() {
        return new ArrayList<>(Arrays.asList(
                new TrainConsistMgmnt.Bogie("Sleeper", 72),
                new TrainConsistMgmnt.Bogie("AC Chair", 56),
                new TrainConsistMgmnt.Bogie("First Class", 24),
                new TrainConsistMgmnt.Bogie("Sleeper", 70)
        ));
    }
    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(222, total);
    }
    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmnt.Bogie("General", 90),
                new TrainConsistMgmnt.Bogie("General", 90)
        );
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(180, total);
    }
    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistMgmnt.Bogie> bogies = Collections.singletonList(
                new TrainConsistMgmnt.Bogie("Sleeper", 72)
        );
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(72, total);
    }
    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(0, total);
    }
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        // Verifying that the first element mapped is indeed 72
        Optional<Integer> firstCapacity = bogies.stream()
                .map(b -> b.capacity)
                .findFirst();
        assertEquals(72, firstCapacity.get());
    }
    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        long count = bogies.stream().map(b -> b.capacity).count();
        assertEquals(bogies.size(), count);
    }
    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        int sizeBefore = bogies.size();
        bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(sizeBefore, bogies.size(), "Aggregation must not modify the original list");
        assertEquals("Sleeper", bogies.get(0).name);
    }
}
