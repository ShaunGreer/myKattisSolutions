import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double capacity = scanner.nextDouble();
        double leakRate = scanner.nextDouble();
        double distance = scanner.nextDouble();

        double[] mpg = new double[6];
        for(int i = 0; i < 6; i++){
            scanner.nextInt();
            mpg[i] = scanner.nextDouble();
        }
        int speed = 80;
        for(int i = 5; i > - 1; i--){
            double fuelInTank = capacity/2;
            double time = distance/(speed * 1.0);
            if (fuelInTank - distance/mpg[i] - leakRate*time > 0){
                System.out.println("YES " + speed);
                return;
            }
            speed -= 5;
        }
        System.out.println("NO");
    }
}
