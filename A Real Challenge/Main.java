import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal a = new BigDecimal(sc.next());
        BigDecimal sqrtOfA = a.sqrt(new MathContext(100));
        System.out.println(sqrtOfA.multiply(BigDecimal.valueOf(4)));

        sc.close();
    }

}