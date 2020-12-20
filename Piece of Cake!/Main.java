import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //Length of whole cake sides
        int h = scanner.nextInt();
        int v = scanner.nextInt();

        int largeSide1 = 0;
        int largeSide2 = 0;
        if (h > (n-h))
            largeSide1 = h;
        else
            largeSide1 = (n-h);
        if (v > (n-v))
            largeSide2 = v;
        else
            largeSide2 = (n-v);

        System.out.println(largeSide1 * largeSide2 * 4);
    }
}
