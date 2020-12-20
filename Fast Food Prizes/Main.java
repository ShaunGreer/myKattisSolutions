import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            //Prize descriptions
            int[][] prizes = new int[n][];
            for (int j = 0; j < n; j++) {
                int k = scanner.nextInt();
                int[] prize = new int[k+1];
                for (int l = 0; l <= k; l++) {
                    prize[l] = scanner.nextInt();
                }
                prizes[j] = prize;
            }
            //Collected tokens
            HashMap<Integer, Integer> available = new HashMap<>(m, 1);
            for (int j = 0; j < m; j++) {
                available.put(j+1, scanner.nextInt());
            }
            //Go through each prize until not enough available
            int cash = 0;
            int index = 0;  //Prize description
            while (index < n){
                boolean doNotIncreaseCash = false;
                //Deal with each prize - if not enough tickets move to next
                HashMap<Integer, Integer> temp = new HashMap<>(available);
                for (int j = 0; j < prizes[index].length - 1; j++) {
                    int required = prizes[index][j];
                    int toUse = available.get(required);
                    if (toUse <= 0){
                        available = new HashMap<>(temp);
                        index++;
                        doNotIncreaseCash = true;
                        break;
                    } else {
                        available.put(required, available.get(required) - 1);
                    }
                }
                if (!doNotIncreaseCash)
                    cash+=prizes[index][prizes[index].length-1];
            }
            System.out.println(cash);
        }
        scanner.close();
    }
}