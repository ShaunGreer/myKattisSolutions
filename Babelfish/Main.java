import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> dictionary = new HashMap<>();
        while (true){
            String line = scanner.nextLine();
            if (line.isBlank())
                break;
            String[] eachWordInLine = line.split(" ");
            dictionary.put(eachWordInLine[1], eachWordInLine[0]);
        }
        while (scanner.hasNext()){
            String toTranslate = scanner.next();
            String translatedWord = dictionary.get(toTranslate);
            if (translatedWord == null)
                System.out.println("eh");
            else
                System.out.println(translatedWord);
        }
        scanner.close();
    }
}