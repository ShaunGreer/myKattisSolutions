import java.util.Scanner;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/rijeci
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int a = 1; // Number of A's
        int b = 0; // Number of B's
        while (k > 0) {
            int tempB = a;
            a = b;
            b += tempB;
            k--;
        }
        System.out.printf("%d %d", a, b);
        scanner.close();
    }
}
