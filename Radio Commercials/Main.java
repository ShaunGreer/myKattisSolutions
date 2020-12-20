import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Read input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] studentsListening = new int[n];
        for (int i = 0; i < n; i++) {
            studentsListening[i] = scanner.nextInt() - p;
        }
        //Kadane's algorithm
        int max_ending_here = studentsListening[0];
        int max_so_far = max_ending_here;
        for (int i = 1; i < n; i++) {
            max_ending_here = max_ending_here + studentsListening[i];
            if (max_ending_here < studentsListening[i])
                max_ending_here = studentsListening[i];     //Start a new sub array
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        System.out.println(max_so_far);
    }
}