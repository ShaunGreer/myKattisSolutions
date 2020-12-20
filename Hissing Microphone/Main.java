import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == 's' && input.charAt(i+1) == 's') {
                System.out.println("hiss");
                return;
            }
        }
        System.out.println("no hiss");
        scanner.close();
    }
}