import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        String fullName = scanner.next();
        String[] nameSplit = fullName.split("-");
        for (String name:nameSplit
             ) {
            output += name.charAt(0);
        }
        System.out.println(output);
    }
}
