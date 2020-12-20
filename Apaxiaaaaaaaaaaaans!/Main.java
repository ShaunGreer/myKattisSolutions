import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder result = new StringBuilder();
        String[] inputAsArray = input.split("");

        for (int i = 0; i < inputAsArray.length-1; i++) {
            if (!inputAsArray[i].equals(inputAsArray[i+1]))
                result.append(inputAsArray[i]);
        }
        result.append(inputAsArray[inputAsArray.length-1]);
        System.out.println(result);
    }
}
