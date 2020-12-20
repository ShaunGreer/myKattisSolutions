import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            String pq = scanner.next();
            int p = Integer.parseInt(pq.split("/")[0]);
            int q = Integer.parseInt(pq.split("/")[1]);
            Deque<Character> path = new LinkedList<>();
            while ((p != 1) || (q != 1)){   //At the root
                if (q > p){        // We went left to get here
                    path.addFirst('L');
                    q -= p;  //Go to parent
                } else {        //We went right to get here
                    path.addFirst('R');
                    p -= q;    //Go to parent
                }
            }
            int counter = 1;
            for (char c: path
                 ) {
                counter *= 2;
                if (c == 'R')
                    counter++;
            }
            System.out.println(k + " " + counter);
        }
        scanner.close();
    }
}