import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int area = 0;
        for (int i = 0; i < n; i++) {
            int wi = scanner.nextInt();
            int li = scanner.nextInt();
            area += (wi * li);
        }
        System.out.println(area/w);
        scanner.close();
    }
}