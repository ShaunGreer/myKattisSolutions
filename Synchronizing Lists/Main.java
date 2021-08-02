import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/synchronizinglists
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0) { // For all input cases
            List<Integer> firstList = new ArrayList<>();
            int[] secondList = new int[n];
            for (int i = 0; i < (2 * n); i++) { // Each individual case
                if (i < n) {
                    firstList.add(scanner.nextInt());
                } else {
                    secondList[i - n] = scanner.nextInt();
                }
            }
            int[] secondListSorted = secondList.clone();
            Arrays.sort(secondListSorted);
            List<Integer> firstListSorted = new ArrayList<>(firstList);
            Collections.sort(firstListSorted);
            int[] resultList = new int[n];
            for (int i = 0; i < n; i++) {
                int firstListElement = firstListSorted.get(i);
                resultList[firstList.indexOf(firstListElement)] = secondListSorted[i];
            }
            Arrays.stream(resultList).forEach(System.out::println);
            System.out.println();
        }

        scanner.close();
    }
}
