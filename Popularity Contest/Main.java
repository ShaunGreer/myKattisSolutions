import java.util.Scanner;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/popularitycontest
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] popularity = new int[n];
        for (int i = 0; i < m; i++) {
            popularity[scanner.nextInt() - 1]++; // The first friend in the friendship
            popularity[scanner.nextInt() - 1]++; // The second friend in the friendship
        }
        for (int i = 0; i < n; i++) {
            System.out.print((popularity[i]) - (i + 1));
            System.out.print(" ");
        }
        scanner.close();
    }
}
