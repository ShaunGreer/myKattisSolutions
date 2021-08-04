import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/herman
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        System.out.println(Math.PI * Math.pow(r, 2));
        System.out.println(2 * Math.pow(r, 2));
        scanner.close();
    }
}
