import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Receiving input
        int n = scanner.nextInt();
        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(scanner.next());
        }
        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            char typed = input.charAt(i);
            char letterA = '*';
            char letterB = '*';
            char letterC = '*';
            char letterD = '*';
            switch (typed){
                case '2':
                    letterA = 'a';
                    letterB = 'b';
                    letterC = 'c';
                    letterD = '%';
                    break;
                case '3':
                    letterA = 'd';
                    letterB = 'e';
                    letterC = 'f';
                    letterD = '%';
                    break;
                case '4':
                    letterA = 'g';
                    letterB = 'h';
                    letterC = 'i';
                    letterD = '%';
                    break;
                case '5':
                    letterA = 'j';
                    letterB = 'k';
                    letterC = 'l';
                    letterD = '%';
                    break;
                case '6':
                    letterA = 'm';
                    letterB = 'n';
                    letterC = 'o';
                    letterD = '%';
                    break;
                case '7':
                    letterA = 'p';
                    letterB = 'q';
                    letterC = 'r';
                    letterD = 's';
                    break;
                case '8':
                    letterA = 't';
                    letterB = 'u';
                    letterC = 'v';
                    letterD = '%';
                    break;
                case '9':
                    letterA = 'w';
                    letterB = 'x';
                    letterC = 'y';
                    letterD = 'z';
            }
            for (int j = 0; j < dictionary.size(); j++) {
                if (dictionary.get(j).charAt(i) == letterA
                        || dictionary.get(j).charAt(i) == letterB
                        || dictionary.get(j).charAt(i) == letterC
                        || dictionary.get(j).charAt(i) == letterD)
                    continue;
                else
                    dictionary.remove(j);
            }
        }
        System.out.println(dictionary.size());

        scanner.close();
    }
}