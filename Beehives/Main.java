
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            double d = scanner.nextDouble();
            if (d == 0.0) {
                scanner.close();
                return;
            }
            int hives = scanner.nextInt();
            Queue<double[]> allHives = new LinkedList<>();
            int sweetCount = 0;
            int sourCount = 0;
            for (int i = 0; i < hives; i++){
                double[]hive = new double[2];
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                hive[0] = x;
                hive[1] = y;
                allHives.add(hive);
            }

            for (int j = 0; j < allHives.size(); j++){
                double[] current = allHives.remove();
                for(double[] hive: allHives){
                    double xSquared = (hive[0] - current[0]) * (hive[0] - current[0]);
                    double ySquared = (hive[1] - current[1]) * (hive[1] - current[1]);
                    if (Math.sqrt(xSquared + ySquared) <= d){
                        sourCount++;
                        sweetCount--;
                        break;
                    }
                }
                sweetCount++;
                allHives.add(current);
            }
            System.out.println(sourCount + " sour, " + sweetCount + " sweet");
            allHives.clear();
        }
    }
}
