import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        double totalSurface = Math.PI * r * r;
        double crust = Math.PI * ((r*r) - ((r-c)*(r-c)));
        double difference = totalSurface - crust;
        System.out.println(difference / totalSurface * 100.0);
    }
}