import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String enciphered = scanner.next();

        char[][] matrix = createMatrix(enciphered.length());
        int index = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++){
                matrix[r][c] = enciphered.charAt(index);
                index++;
            }
        }

        StringBuilder s = new StringBuilder(enciphered.length());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s.append(matrix[i][j]);
            }
        }
        System.out.println(s.toString());
        scanner.close();
    }

    private static char[][] createMatrix(int n){
        HashMap<Integer, Integer> multiples = getMultiples(n);
        int rows = Collections.max(multiples.keySet());
        int columns = multiples.get(rows);

        return new char[rows][columns];
    }

    private static HashMap<Integer, Integer> getMultiples(int n){
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i < n; i++){
            if (n % i == 0) {
                if (i > (n/i))
                    break;
                result.put(i, (n / i));
            }
        }
        return result;
    }

}
