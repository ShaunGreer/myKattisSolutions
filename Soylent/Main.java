import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/soylent
 */
public class Main {
    public static void main(String[] args) {
        int caloriesPerBottle = 400;
        DecimalFormat df = new DecimalFormat("#");
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int caloriesToAchieve = scanner.nextInt();
            System.out.println(df.format(Math.ceil((caloriesToAchieve * 1.0) / caloriesPerBottle)));
        }
        scanner.close();
    }
}
