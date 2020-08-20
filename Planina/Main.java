import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int squares = 1;
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            squares *= 4;
            total = Math.pow((Math.sqrt(squares) + 1), 2);
        }
        System.out.println((int)(total));
    }
}