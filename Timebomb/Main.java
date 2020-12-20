import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> allDigits = new ArrayList<>();
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 = scanner.nextLine();
        String line4 = scanner.nextLine();
        String line5 = scanner.nextLine();
        for (int i = 0; i < line1.length(); i+=4) {
            String[] current = new String[5];
            current[0] = line1.substring(i, i+3);
            current[1] = line2.substring(i, i+3);
            current[2] = line3.substring(i, i+3);
            current[3] = line4.substring(i, i+3);
            current[4] = line5.substring(i, i+3);
            allDigits.add(current);
        }
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < allDigits.size(); i++) {
            int valueOfDigit = value(allDigits.get(i));
            if (valueOfDigit == -1) {
                System.out.println("BOOM!!");
                return;
            }
            else
                total.append(valueOfDigit);
        }
        if (Integer.parseInt(total.toString()) % 6 == 0)
            System.out.println("BEER!!");
        else
            System.out.println("BOOM!!");
        scanner.close();
    }

    private static int value(String[] digit){
        String topLine = digit[0];
        String secondLine = digit[1];
        String thirdLine = digit[2];
        String fourthLine = digit[3];
        String fifthLine = digit[4];
        if (topLine.equals("***") && secondLine.equals("* *") && thirdLine.equals("* *") && fourthLine.equals("* *") && fifthLine.equals("***"))
            return 0;
        if (topLine.equals("  *") && secondLine.equals("  *") && thirdLine.equals("  *") && fourthLine.equals("  *") && fifthLine.equals("  *"))
            return 1;
        if (topLine.equals("***") && secondLine.equals("  *") && thirdLine.equals("***") && fourthLine.equals("*  ") && fifthLine.equals("***"))
            return 2;
        if (topLine.equals("***") && secondLine.equals("  *") && thirdLine.equals("***") && fourthLine.equals("  *") && fifthLine.equals("***"))
            return 3;
        if (topLine.equals("* *") && secondLine.equals("* *") && thirdLine.equals("***") && fourthLine.equals("  *") && fifthLine.equals("  *"))
            return 4;
        if (topLine.equals("***") && secondLine.equals("*  ") && thirdLine.equals("***") && fourthLine.equals("  *") && fifthLine.equals("***"))
            return 5;
        if (topLine.equals("***") && secondLine.equals("*  ") && thirdLine.equals("***") && fourthLine.equals("* *") && fifthLine.equals("***"))
            return 6;
        if (topLine.equals("***") && secondLine.equals("  *") && thirdLine.equals("  *") && fourthLine.equals("  *") && fifthLine.equals("  *"))
            return 7;
        if (topLine.equals("***") && secondLine.equals("* *") && thirdLine.equals("***") && fourthLine.equals("* *") && fifthLine.equals("***"))
            return 8;
        if (topLine.equals("***") && secondLine.equals("* *") && thirdLine.equals("***") && fourthLine.equals("  *") && fifthLine.equals("***"))
            return 9;
        return -1;
    }
}