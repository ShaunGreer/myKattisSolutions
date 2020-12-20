import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[]companyLoc = new int[n];

        for(int j = 0; j < n; j++){
            companyLoc[j] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++){
            int type = scanner.nextInt();
            if (type == 1){
                companyLoc[scanner.nextInt()-1] = scanner.nextInt();
            }else{
                int compALoc = companyLoc[scanner.nextInt()-1];
                int compBLoc = companyLoc[scanner.nextInt()-1];
                System.out.println(Math.abs(compALoc - compBLoc));
            }
        }
    }
}
