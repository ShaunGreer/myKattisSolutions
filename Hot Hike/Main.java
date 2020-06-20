import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> allTemps = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int temp = scanner.nextInt();
            allTemps.add(temp);
        }

        int lowIndex = 0;
        List<Integer>copy = new ArrayList<>(allTemps);
        Collections.sort(copy);
        int lowTemp = copy.get(copy.size()-1);

        for (int j = 0; j < allTemps.size()-2; j++){
            int max = Math.max(allTemps.get(j), allTemps.get(j+2));
            if (max <  lowTemp){
                lowTemp = max;
                lowIndex = j;
            }
        }

        System.out.println(lowIndex + 1 + " " + lowTemp);
    }
}
