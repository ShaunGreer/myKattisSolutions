import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> allPossibilities = new ArrayList<>();
        int biggestDifference = 0;
        int lowest = 0;
        int highest = 0;
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if ((end - start) >= biggestDifference) {
                biggestDifference = end - start;
                lowest = start;
                highest = end;
            }
            List<Integer> current = addPossibleStartTimes(start, end);
            allPossibilities.add(current);
        }
        List<Integer> matchingStartTimes = addPossibleStartTimes(lowest, highest);
        for (int i = 0; i < allPossibilities.size() ; i++) {
            List<Integer> current = allPossibilities.get(i);
            matchingStartTimes.retainAll(current);
        }
        if (matchingStartTimes.size() == 0)
            System.out.println("edward is right");
        else
            System.out.println("gunilla has a point");
    }


    private static List<Integer> addPossibleStartTimes(int start, int end){
        List<Integer> possibilities = new ArrayList<>();
        for (int i = start; i <= end ; i++) {
            possibilities.add(i);
        }
        return possibilities;
    }
}