import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            int total = 0;
            int[] allScores = new int[n];
            for (int j = 0; j < n; j++) {
                int current = scanner.nextInt();
                allScores[j] = current;
                total += current;
            }
            BigDecimal average = new BigDecimal(total/n + "");
            BigDecimal count = new BigDecimal("0");
            for (int j = 0; j < n; j++) {
                if (average.compareTo(new BigDecimal(allScores[j])) < 0)
                    count = count.add(new BigDecimal("1"));
            }
            System.out.println(to3Decimals(count, BigDecimal.valueOf(n)) + "%");
        }
        scanner.close();
    }

    private static String to3Decimals(BigDecimal count, BigDecimal n){
        BigDecimal temp =  (count.divide(n, 3, RoundingMode.HALF_UP));
        return (count.divide(n, 5, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).setScale(3,RoundingMode.HALF_UP).toString();
     }
}