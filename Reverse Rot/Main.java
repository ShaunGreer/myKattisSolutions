
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t;
        while (true){
            t = scanner.nextInt();
            if (t == 0)
                break;
            String original = scanner.next();
            String reversed = reverse(original);
            System.out.println(rotate(reversed, t));
        }
        scanner.close();
    }

    private static String reverse(String text){
        String reversed = "";
        for (int i = text.length() - 1; i > -1; i--){
            reversed += text.charAt(i);
        }
        return reversed;
    }

    private static String rotate(String text, int times){
        String rotated = "";
        for (int i = 0; i < text.length(); i++){
            char current = text.charAt(i);
            for (int j = 0; j < times; j++){
                current++;
                if (current == 91)
                    current = 95;
                else if (current == 96)
                    current = 46;
                else if (current == 47)
                    current = 65;
            }
            rotated += current;
        }
        return rotated;
    }
}
