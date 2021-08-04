import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/compoundwords
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> allWords = new ArrayList<>();
        while(scanner.hasNext()) {
            allWords.add(scanner.next());
        }
        Set<String> allCompoundWords = new HashSet<>();
        for (int i = 0; i < allWords.size(); i++) {
            String word = allWords.remove(0);
            for (String otherWord : allWords) { // 1 less now
                allCompoundWords.add(word + otherWord);
            }
            allWords.add(word);
        }
        List<String> sortedCompoundWords = new ArrayList<>(allCompoundWords);
        Collections.sort(sortedCompoundWords);
        sortedCompoundWords.forEach(System.out::println);
        scanner.close();
    }
}
