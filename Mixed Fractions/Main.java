import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int top = scanner.nextInt();
            int bottom = scanner.nextInt();
            if (top == 0 & bottom == 0)
                return;

            double t = top * 1.0;
            double b = bottom * 1.0;
            double res = t / b;
            long iPart = (long) res;
            double fPart = res - iPart;

            if (top < bottom)
                System.out.println(0 + " " + top + " / " + bottom);
            else
                System.out.println(iPart + " " + Math.round(fPart * bottom) + " / " + bottom);
        }
        scanner.close();
    }
}

 //   int counter = 0;
//            int tempBottom = bottom;
//            while((tempBottom + bottom) <= top){
//                counter++;
//                tempBottom += bottom;
//            }