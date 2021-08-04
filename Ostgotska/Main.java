import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/ostgotska
 */
public class Main {
    public static void main(String[] args) {
        String inOstgotska = "dae ae ju traeligt va";
        String inRikssvenska = "haer talar vi rikssvenska";
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        String[] sentenceSplit = sentence.split(" ");
        double aeCount = 0.0;
        for (int i = 0; i < sentenceSplit.length; i++) {
            if(sentenceSplit[i].contains("ae")) {
                aeCount++;
            }
        }
        if ((aeCount / sentenceSplit.length) >= 0.4) {
            System.out.println(inOstgotska);
        } else {
            System.out.println(inRikssvenska);
        }
        scanner.close();
    }
}
