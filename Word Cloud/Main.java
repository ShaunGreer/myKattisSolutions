import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/wordcloud
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, w, count = 1;   //W is max width of cloud, N is number of words
        while ((w = scanner.nextInt()) != 0 && (n = scanner.nextInt()) != 0){
            Tuple[] cloudWords = new Tuple[n];
            int maxOccurrences = 0;

            for (int i = 0; i < n; i++) {   //Reading input
                String word = scanner.next();
                int occurrences = scanner.nextInt();
                if (occurrences > maxOccurrences)
                    maxOccurrences = occurrences;
                cloudWords[i] = new Tuple(word, occurrences);
            }

            double totalHeight = 0, widthOfLine = 0;
            double currentMaxHeightOfLine = 0;
            double space = Math.ceil((9/16.0) * 10);

            for (int i = 0; i < n; i++) {   //Each line
                String word = cloudWords[i].x;
                int occurrences = cloudWords[i].y;
                double pointSize = 8 + Math.ceil((40.0 * (occurrences - 4.0)) / (maxOccurrences - 4.0));
                double widthOfWord = Math.ceil((9 / 16.0) * word.length() * pointSize);
                if(widthOfLine + widthOfWord > w){
                    totalHeight += currentMaxHeightOfLine;
                    currentMaxHeightOfLine = pointSize;
                    widthOfLine = widthOfWord + 10;
                } else {
                    widthOfLine += widthOfWord + 10;
                    if (pointSize > currentMaxHeightOfLine)
                        currentMaxHeightOfLine = pointSize;
                }
            }
            totalHeight += currentMaxHeightOfLine;
            System.out.println("CLOUD " + count + ": " + Math.round(totalHeight));
            count++;
        }
        scanner.close();
    }

    static class Tuple{
        String x;
        int y;

        public Tuple(String x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
