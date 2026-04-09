package com.railway;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmntTest {

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
