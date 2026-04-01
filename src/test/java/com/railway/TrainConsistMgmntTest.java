package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmntTest {

    private List<TrainConsistMgmnt.Bogie> getMockBogies() {
        return new ArrayList<>(Arrays.asList(
                new TrainConsistMgmnt.Bogie("Sleeper", 72),
                new TrainConsistMgmnt.Bogie("General", 90),
                new TrainConsistMgmnt.Bogie("AC Chair", 56),
                new TrainConsistMgmnt.Bogie("First Class", 24)
        ));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        // Filtering > 72 should exclude the Sleeper (72)
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 72)
                .collect(Collectors.toList());
        assertFalse(result.stream().anyMatch(b -> b.capacity == 72));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        assertEquals(3, result.size()); // Sleeper, General, AC Chair
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 200)
                .collect(Collectors.toList());
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());
        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        List<TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        int originalSize = bogies.size();

        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());

        assertEquals(originalSize, bogies.size(), "Original list size should not change");
        assertEquals("Sleeper", bogies.get(0).name);
    }
}
