package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmntTest {

    // Helper to generate a test list
    private List<TrainConsistMgmnt.Bogie> getMockBogies() {
        return new ArrayList<>(Arrays.asList(
                new TrainConsistMgmnt.Bogie("Sleeper", 72),
                new TrainConsistMgmnt.Bogie("Sleeper", 72),
                new TrainConsistMgmnt.Bogie("AC Chair", 56),
                new TrainConsistMgmnt.Bogie("General", 90)
        ));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        Map<String, List<TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("General"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        Map<String, List<TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size(), "Sleeper group should have 2 bogies");
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        Map<String, List<TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        Map<String, List<TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        Set<String> expectedKeys = new HashSet<>(Arrays.asList("Sleeper", "AC Chair", "General"));
        assertEquals(expectedKeys, grouped.keySet());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistMgmnt.Bogie> bogies = getMockBogies();
        int originalSize = bogies.size();

        bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        assertEquals(originalSize, bogies.size(), "Original list must remain unchanged");
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainConsistMgmnt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmnt.Bogie("Sleeper", 72),
                new TrainConsistMgmnt.Bogie("Sleeper", 72)
        );
        Map<String, List<TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
    }
}
