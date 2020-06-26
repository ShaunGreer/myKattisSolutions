import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){
            int stops = scanner.nextInt();
            double passengers = 0;
            for (int j = 0; j < stops; j++){
                passengers += (0.5);
                passengers *= 2;
            }
            System.out.println((int)passengers);
        }
        scanner.close();
    }
}
