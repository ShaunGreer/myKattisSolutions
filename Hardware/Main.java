
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
//new File("src/1.in")
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        int orders = scanner.nextInt();
        scanner.nextLine();
        String road = "";
        String type = "";
        for (int i = 0; i < orders; i++){
            int[] digits = new int[10];
            if (road.equals(""))
                road = scanner.nextLine();
            else
                road  = type + " " + scanner.next();
            int houses = scanner.nextInt();
            scanner.next(); //Skip the word addresses
            if (houses == 1)
                System.out.println(road + "\n" + houses + " address");
            else
                System.out.println(road + "\n" + houses + " addresses");

            type = scanner.next();
            while (type.equals("+") || (type.charAt(0) > 47 && type.charAt(0) < 58)) {
                if (type.equals("+")) {
                    String start = scanner.next();
                    String end = scanner.next();
                    String jump = scanner.next();
                    String current = start;
                    while ((Integer.parseInt(current) <= Integer.parseInt(end))){
                        for (int k = 0; k < current.length(); k++) {
                            digits = increaseCount(current.charAt(k), digits);
                        }
                        current = String.valueOf(Integer.parseInt(current) + Integer.parseInt(jump));
                    }
                    type = scanner.next();
                } else {
                    for (int j = 0; j < type.length(); j++) {
                        digits = increaseCount(type.charAt(j), digits);
                    }
                    if (scanner.hasNext())
                        type = scanner.next();
                    else
                        break;
                }
            }
            int total = 0;
            for (int j = 0; j < digits.length; j++) {
                System.out.println("Make " + digits[j] + " digit " + j);
                total += digits[j];
            }
            if (total == 1)
                System.out.println("In total 1 digit");
            else
                System.out.println("In total " + total + " digits");
        }

        scanner.close();
    }

    private static int[] increaseCount(char number, int[] digitCount){
        switch (number){
            case '0':
                digitCount[0]+=1;
                break;
            case '1':
                digitCount[1]+=1;
                break;
            case '2':
                digitCount[2]+=1;
                break;
            case '3':
                digitCount[3]+=1;
                break;
            case '4':
                digitCount[4]+=1;
                break;
            case '5':
                digitCount[5]+=1;
                break;
            case '6':
                digitCount[6]+=1;
                break;
            case '7':
                digitCount[7]+=1;
                break;
            case '8':
                digitCount[8]+=1;
                break;
            case '9':
                digitCount[9]+=1;
                break;
        }
        return digitCount;
    }
}
