import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        while (n != 0){
            String favWord = "";
            int favCount = -1;

            for (int i = 0; i < n; i++) {
                String current = scanner.next();
                int doubleVowelCount = 0;
                for (int j = 0; j < current.length()-1; j++) {
                    switch (current.charAt(j)){
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                        case 'y':
                            if (current.charAt(j+1) == current.charAt(j)){
                                doubleVowelCount++;
                                j++;
                            }
                    }
                }
                if (doubleVowelCount > favCount){
                    favCount = doubleVowelCount;
                    favWord = current;
                }
            }
            System.out.println(favWord);
            n = scanner.nextInt();
        }
        scanner.close();
    }
}