
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Character, String> alphabet = getAlphabet();
        String original = scanner.nextLine().toLowerCase();
        String result = "";
        for (int i = 0; i < original.length(); i++){
            char current = original.charAt(i);
            if (current >= 97 && current <= 122){
                result += alphabet.get(current);
            } else {
                result += current;
            }
        }
        System.out.println(result);
        scanner.close();
    }

    private static HashMap<Character, String> getAlphabet(){
        HashMap<Character, String> alphabet = new HashMap<>(26);

        alphabet.put('a', "@");
        alphabet.put('b', "8");
        alphabet.put('c', "(");
        alphabet.put('d', "|)");
        alphabet.put('e', "3");
        alphabet.put('f', "#");
        alphabet.put('g', "6");
        alphabet.put('h', "[-]");
        alphabet.put('i', "|");
        alphabet.put('j', "_|");
        alphabet.put('k', "|<");
        alphabet.put('l', "1");
        alphabet.put('m', "[]\\/[]");
        alphabet.put('n', "[]\\[]");
        alphabet.put('o', "0");
        alphabet.put('p', "|D");
        alphabet.put('q', "(,)");
        alphabet.put('r', "|Z");
        alphabet.put('s', "$");
        alphabet.put('t', "']['");
        alphabet.put('u', "|_|");
        alphabet.put('v', "\\/");
        alphabet.put('w', "\\/\\/");
        alphabet.put('x', "}{");
        alphabet.put('y', "`/");
        alphabet.put('z', "2");

        return alphabet;
    }
}
