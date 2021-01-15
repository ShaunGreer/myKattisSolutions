import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String quadKey = scanner.next();
        double half = Math.sqrt(Math.pow(4, quadKey.length())) / 2;
        int x = 0, y = 0;
        for(int i = 0; i < quadKey.length(); i++){
            switch (quadKey.charAt(i)){
                case '0':
                    break;
                case '1':
                    x += half;
                    break;
                case '2':
                    y += half;
                    break;
                default:
                    x += half;
                    y += half;
            }
            half /= 2;
        }
        System.out.println(quadKey.length() + " " + x + " " + y);

        scanner.close();
    }

}