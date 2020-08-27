import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        HashMap<String, Integer> dictionary = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            String word = scanner.next();
            int value = scanner.nextInt();
            dictionary.put(word, value);
            if (word.length() < minLength)
                minLength = word.length();
            if (word.length() > maxLength)
                maxLength = word.length();
        }
        scanner.nextLine();
        int total = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals(".")){
                System.out.println(total);
                total = 0;
                continue;
            }
            String[] eachWord = line.split(" ");
            for (int i = 0; i < eachWord.length; i++) {
                if (eachWord[i].length() < minLength || eachWord[i].length() > maxLength)
                    continue;
                else {
                    Integer value = dictionary.get(eachWord[i]);
                    if (value != null)
                        total += value;
                }
            }
        }
    }
}