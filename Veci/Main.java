import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/veci
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] x = scanner.next().toCharArray();
        for (int i = x.length - 1; i > 0; i--) {
            if (x[i - 1] < x[i]) {
                int smallestNum = Character.getNumericValue(x[i]);
                int smallestIndex = i;
                for (int j = i + 1; j < x.length; j++) {
                    int numToCheck = Character.getNumericValue(x[j]);
                    if (numToCheck < smallestNum && numToCheck > Character.getNumericValue(x[i - 1])) {
                        smallestIndex = j;
                        smallestNum = numToCheck;
                    }
                }
                x[smallestIndex] = x[i - 1];
                x[i - 1] = Character.forDigit(smallestNum, 10);
                Arrays.sort(x, i, x.length);
                System.out.println(x);
                return;
            }
        }
        System.out.println(0);
        scanner.close();
    }
}
