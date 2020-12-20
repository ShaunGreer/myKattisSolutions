import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (value < 0)
                total += value;
        }
        System.out.println(Math.abs(total));
    }
}