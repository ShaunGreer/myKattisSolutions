import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n % 2 == 1)
            System.out.println("Either");
        else if ((n/2) % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
        scanner.close();
    }
}
