import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        double c = 2 * Math.PI * 30;
        double eachLetterDist = c / 28.0;
        HashMap<Character, Integer> letterValues = getLinks();
        for (int i = 0; i < n; i++) {
            String phrase = scanner.nextLine();
            double totalFeet = 0.0;
            for (int j = 0; j < phrase.length()-1; j++) {
                int clockwise = getClockwiseDist(phrase.charAt(j), phrase.charAt(j+1), letterValues);
                int anticlockwise = getAntiClockDist(phrase.charAt(j), phrase.charAt(j+1), letterValues);
                if (clockwise < anticlockwise)
                    totalFeet += (clockwise * eachLetterDist);
                else
                    totalFeet += (anticlockwise * eachLetterDist);
            }
            double timeTaken = totalFeet / 15.0;
            timeTaken += phrase.length();
            System.out.println(timeTaken);
        }
        scanner.close();
    }

    private static int getAntiClockDist(char a, char b, HashMap<Character, Integer> links){
        int distance = 0;
        int aVal = links.get(a);
        int bVal = links.get(b);
        while (aVal != bVal){
            distance++;
            aVal--;
            if (aVal < 1)
                aVal = 28;
        }
        return distance;
    }

    private static int getClockwiseDist(char a, char b, HashMap<Character, Integer> links){
        int distance = 0;
        int aVal = links.get(a);
        int bVal = links.get(b);
        while (aVal != bVal){
            distance++;
            aVal++;
            if (aVal > 28)
                aVal = 1;
        }
        return distance;
    }

    /**
     * Helper method to link each letter to number.
     * This will help calculate the distance travelled around the circle
     */
    private static HashMap<Character, Integer> getLinks(){
        HashMap<Character, Integer> links = new HashMap<>();
        links.put('A', 1);
        links.put('B', 2);
        links.put('C', 3);
        links.put('D', 4);
        links.put('E', 5);
        links.put('F', 6);
        links.put('G', 7);
        links.put('H', 8);
        links.put('I', 9);
        links.put('J', 10);
        links.put('K', 11);
        links.put('L', 12);
        links.put('M', 13);
        links.put('N', 14);
        links.put('O', 15);
        links.put('P', 16);
        links.put('Q', 17);
        links.put('R', 18);
        links.put('S', 19);
        links.put('T', 20);
        links.put('U', 21);
        links.put('V', 22);
        links.put('W', 23);
        links.put('X', 24);
        links.put('Y', 25);
        links.put('Z', 26);
        links.put(' ', 27);
        links.put('\'', 28);
        return links;
    }
}