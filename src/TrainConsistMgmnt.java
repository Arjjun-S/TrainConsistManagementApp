import java.util.*;
public class TrainConsistMgmnt {
    static void main() {
        System.out.println("==========================================");
        System.out.println("   === Train Consist Management App ===   ");
        System.out.println("==========================================");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Consist : "+trainConsist.size());
        System.out.print("Current Train Consist : [");
        for(int i=0;i<trainConsist.size();i++)
        {
            System.out.print(trainConsist.get(i)+",");
        }
        System.out.print("]");
    }
}