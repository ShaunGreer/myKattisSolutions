import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/stopwatch
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n % 2 != 0) { // Odd number of clicks
            System.out.println("still running");
            return;
        }
        int totalTime = 0;
        for (int i = 0; i < (n / 2); i++) {
            int firstClick = scanner.nextInt();
            int secondClick = scanner.nextInt();
            totalTime += (secondClick - firstClick);
        }
        System.out.println(totalTime);
        scanner.close();
    }
}
