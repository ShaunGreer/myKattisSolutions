import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> values = getValues();
        List<StringBuilder> allAsciiArt = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            String line = scanner.nextLine();
            int index = 0;
            for (int j = 0; j < line.length(); j+=6) {
                String digitLine = line.substring(j, j + 5);
                if (allAsciiArt.size() <= index)
                    allAsciiArt.add(new StringBuilder(digitLine));
                else
                    allAsciiArt.set(index, allAsciiArt.get(index).append(digitLine));
                index++;
            }
        }
        StringBuilder expression = new StringBuilder();
        allAsciiArt.stream().forEach(digit -> expression.append(values.get(digit.toString())));
        int plusSign = expression.indexOf("+");
        String num1 = expression.substring(0, plusSign);
        String num2 = expression.substring(plusSign + 1);
        String result = String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
        printArt(result);
        scanner.close();
    }

    private static void printArt(String answer){
        HashMap<String, String> asciiArt = getArt();
        int index = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < answer.length(); j++) {
                String toSearch = String.valueOf(answer.charAt(j));
                String toOutput = asciiArt.get(toSearch);
                String display = toOutput.substring(index, index + 5);
                if (j == answer.length() - 1)
                    System.out.print(display);
                else
                    System.out.print(display + ".");
            }
            System.out.println();
            index += 5;
        }
    }

    private static HashMap<String, String> getValues(){
        HashMap<String, String> values = new HashMap<>(11);
        values.put("xxxxxx...xx...xx...xx...xx...xxxxxx", "0");
        values.put("....x....x....x....x....x....x....x", "1");
        values.put("xxxxx....x....xxxxxxx....x....xxxxx", "2");
        values.put("xxxxx....x....xxxxxx....x....xxxxxx", "3");
        values.put("x...xx...xx...xxxxxx....x....x....x", "4");
        values.put("xxxxxx....x....xxxxx....x....xxxxxx", "5");
        values.put("xxxxxx....x....xxxxxx...xx...xxxxxx", "6");
        values.put("xxxxx....x....x....x....x....x....x", "7");
        values.put("xxxxxx...xx...xxxxxxx...xx...xxxxxx", "8");
        values.put("xxxxxx...xx...xxxxxx....x....xxxxxx", "9");
        values.put(".......x....x..xxxxx..x....x.......", "+");
        return values;
    }

    private static HashMap<String, String> getArt(){
        HashMap<String, String> values = new HashMap<>(11);
        values.put("0", "xxxxxx...xx...xx...xx...xx...xxxxxx");
        values.put("1", "....x....x....x....x....x....x....x");
        values.put("2", "xxxxx....x....xxxxxxx....x....xxxxx");
        values.put("3", "xxxxx....x....xxxxxx....x....xxxxxx");
        values.put("4", "x...xx...xx...xxxxxx....x....x....x");
        values.put("5", "xxxxxx....x....xxxxx....x....xxxxxx");
        values.put("6", "xxxxxx....x....xxxxxx...xx...xxxxxx");
        values.put("7", "xxxxx....x....x....x....x....x....x");
        values.put("8", "xxxxxx...xx...xxxxxxx...xx...xxxxxx");
        values.put("9", "xxxxxx...xx...xxxxxx....x....xxxxxx");
        values.put("+", ".......x....x..xxxxx..x....x.......");
        return values;
    }
}