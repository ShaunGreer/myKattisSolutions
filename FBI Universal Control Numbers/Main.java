import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        HashMap<Character, Integer> mappings = getMappings();
        for (int i = 0; i < p; i++) {
            int k = scanner.nextInt();
            String d = scanner.next();
            d = replaceAllConfusion(d);
            int checkValue = (
                    (2 * mappings.get(d.charAt(0))) +
                    (4 * mappings.get(d.charAt(1))) +
                    (5 * mappings.get(d.charAt(2))) +
                    (7 * mappings.get(d.charAt(3))) +
                    (8 * mappings.get(d.charAt(4))) +
                    (10 * mappings.get(d.charAt(5))) +
                    (11 * mappings.get(d.charAt(6))) +
                    (13 * mappings.get(d.charAt(7)))
            ) % 27;
            char checkDigit = '\0';
            for (char key:mappings.keySet()
                 ) {
                if (mappings.get(key) == checkValue){
                    checkDigit = key;
                    break;
                }
            }
            if (checkDigit == d.charAt(8))
                System.out.println(k + " " + decimalValue(d, mappings));
            else
                System.out.println(k + " Invalid");
        }
        scanner.close();
    }

    private static BigInteger decimalValue(String d, HashMap<Character, Integer> mappings){
        BigInteger total = BigInteger.ZERO;
        double value = Math.pow(27,7);
        for (int i = 0; i < 8; i++) {
            total = total.add(BigDecimal.valueOf(value * mappings.get(d.charAt(i))).toBigInteger());
            value /= 27;
        }
        return total;
    }

    private static String replaceAllConfusion(String word){
        return word.replace('B', '8')
                .replace('G', 'C')
                .replace('I', '1')
                .replace('O', '0')
                .replace('Q', '0')
                .replace('S', '5')
                .replace('U', 'V')
                .replace('Y', 'V')
                .replace('Z', '2');
    }

    private static HashMap<Character, Integer> getMappings(){
        HashMap<Character, Integer> mappings = new HashMap<>();
        mappings.put('0', 0);
        mappings.put('1', 1);
        mappings.put('2', 2);
        mappings.put('3', 3);
        mappings.put('4', 4);
        mappings.put('5', 5);
        mappings.put('6', 6);
        mappings.put('7', 7);
        mappings.put('8', 8);
        mappings.put('9', 9);
        mappings.put('A', 10);
        mappings.put('C', 11);
        mappings.put('D', 12);
        mappings.put('E', 13);
        mappings.put('F', 14);
        mappings.put('H', 15);
        mappings.put('J', 16);
        mappings.put('K', 17);
        mappings.put('L', 18);
        mappings.put('M', 19);
        mappings.put('N', 20);
        mappings.put('P', 21);
        mappings.put('R', 22);
        mappings.put('T', 23);
        mappings.put('V', 24);
        mappings.put('W', 25);
        mappings.put('X', 26);
        return mappings;
    }
}