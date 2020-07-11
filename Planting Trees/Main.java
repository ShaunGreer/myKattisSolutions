import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] trees = new int[n];
        int time = 0;

        for (int i = 0; i < n; i++)
            trees[i] = scanner.nextInt();

        Arrays.sort(trees);
        int counter = n-1;
        for (int i = n-1; i >= 0; i--){
            trees[i] = trees[i] - counter;
            counter--;
            time++;
        }

        Arrays.sort(trees);
        time += trees[trees.length-1];
        System.out.println(time + 1);
        scanner.close();
    }

}