import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int groupSize = scanner.nextInt();
        HashSet<Integer> duplicates = new HashSet<>();
        List<Integer> allRolls = new ArrayList<>();
        for (int i = 0; i < groupSize; i++) {
            int current = scanner.nextInt();
            if (allRolls.contains(current))
                duplicates.add(current);
            allRolls.add(current);
        }
        List<Integer> copy = new ArrayList<>(allRolls);
        copy.removeAll(duplicates);
        if (copy.size() == 0)
            System.out.println("none");
        else {
            Collections.sort(copy);
            System.out.println(allRolls.indexOf(copy.get(copy.size() - 1)) + 1);
        }

        scanner.close();
    }
}