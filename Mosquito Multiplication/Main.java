import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int M = scanner.nextInt();
            int P = scanner.nextInt();
            int L = scanner.nextInt();
            int E = scanner.nextInt();
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            int N = scanner.nextInt();

            while (N > 0){
                int tempP = P;
                P = L/R;
                L = E*M;
                M = tempP/S;
                N--;
            }

            System.out.println(M);
        }
    }
}
