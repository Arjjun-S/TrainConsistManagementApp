package com.railway;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class TrainConsistMgmntTest {
    @Test
    public void testBogieSortingLogic() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        assertEquals(24, bogies.get(0).capacity);
        assertEquals("First Class", bogies.get(0).name);
    }
    @Test
    public void testHighestCapacityPosition() {
        List<TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        int lastIndex = bogies.size() - 1;
        assertEquals(90, bogies.get(lastIndex).capacity);
        assertEquals("General", bogies.get(lastIndex).name);
    }
}
