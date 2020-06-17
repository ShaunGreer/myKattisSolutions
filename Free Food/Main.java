import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> totalDays = new ArrayList<>();

        scanner.nextInt();
        while(scanner.hasNext()){
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            while(s <= t){
                totalDays.add(s);
                s++;
            }
        }

        Collections.sort(totalDays);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i:totalDays
             ) {
            if(!result.contains(i))
                result.add(i);
        }
        System.out.println(result.size());
    }
}
