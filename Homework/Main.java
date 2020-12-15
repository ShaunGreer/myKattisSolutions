import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            String[] current = input[i].split("-");
            if (current.length == 2)
                total += (Integer.parseInt(current[1]) - Integer.parseInt(current[0])) + 1;
            else
                total += 1;
        }
        System.out.println(total);
    }
}