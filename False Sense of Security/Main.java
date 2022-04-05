import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/falsesecurity
 */
public class Main {

    private static final Map<String, Character> morseCodeMappings = new LinkedHashMap<>(){{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put("..--", '_');
        put("---.", '.');
        put(".-.-", ',');
        put("----", '?');
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String encodedMessage = scanner.nextLine();
            List<String> keyList = new ArrayList<>(morseCodeMappings.keySet());
            // Step 1 - Convert to Morse code
            StringBuilder morseCode = new StringBuilder();
            StringBuilder morseCodeLengths = new StringBuilder();
            for (int i = 0; i < encodedMessage.length(); i++) { // For each character in the encoded message
                char currentEncodedChar = encodedMessage.charAt(i);
                int morseIndex;
                switch (currentEncodedChar) { // Get the Morse code value
                    case '_': morseIndex = 26; break;
                    case '.': morseIndex = 27; break;
                    case ',': morseIndex = 28; break;
                    case '?': morseIndex = 29; break;
                    default: morseIndex = currentEncodedChar % 65;
                }
                morseCode.append(keyList.get(morseIndex));
                morseCodeLengths.append(keyList.get(morseIndex).length());
            }
            // Step 2 - Reverse code lengths
            morseCodeLengths.reverse();
            // Step 3 - Decode message
            StringBuilder decodedMessage = new StringBuilder();
            int codeIndex = 0;
            for (int i = 0; i < morseCodeLengths.length(); i++) {
                int codeLength = codeIndex + Integer.parseInt(String.valueOf(morseCodeLengths.charAt(i)));
                decodedMessage.append(morseCodeMappings.get(morseCode.substring(codeIndex, codeLength)));
                codeIndex = codeLength;
            }
            System.out.println(decodedMessage);
        }
        scanner.close();
    }
}
