import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        //Even split
        if(m % n == 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m/n; j++){
                    System.out.print('*');
                }
                System.out.print('\n');
            }
        //Odd split
        } else {
            int r = m % n;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < m/n + 1; j++){
                    System.out.print('*');
                }
                System.out.print('\n');
            }
            for (int i = 0; i < n - r; i++) {
                for (int j = 0; j < m/n; j++) {
                    System.out.print('*');
                }
                System.out.print('\n');
            }
        }

        sc.close();
    }
}