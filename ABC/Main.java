import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[3];
        char[] letters = new char[3];

        for (int i = 0; i < 3; i++) {
            values[i] = scanner.nextInt();
        }
        Arrays.sort(values);
        String word = scanner.next();
        for (int i = 0; i < 3; i++) {
            letters[i] = word.charAt(i);
        }

        StringBuilder output = new StringBuilder(5);
        for (int i = 0; i < 3; i++) {
            switch (letters[i]){
                case 'A':
                    output.append(values[0]);
                    break;
                case 'B':
                    output.append(values[1]);
                    break;
                default:
                    output.append(values[2]);
            }
            output.append(" ");
        }
        System.out.println(output.toString().trim());
        scanner.close();
    }

}
