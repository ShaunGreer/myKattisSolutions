import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            double r = scanner.nextDouble();
            int m = scanner.nextInt();
            int c = scanner.nextInt();

            if (r == 0.0 && m == 0 && c == 0)
                return;

            double diameter = r * 2;
            double ratio = c/(m*1.0);
            double trueArea  = r * r * Math.PI;
            double estArea = diameter * diameter * ratio;

            System.out.println(trueArea + " " + estArea);
        }
    }
}
