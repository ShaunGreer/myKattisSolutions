
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        String yours = scanner.next();
        String friends = scanner.next();
        int different = 0;
        int same = 0;

        int friendsWrong = friends.length() - k;
        for (int i = 0; i < yours.length(); i++){
            if (yours.charAt(i) != friends.charAt(i))
                different++;
            else
                same++;
        }

        if (different == yours.length())
            System.out.println(friendsWrong);
        else if (different == 0)
            System.out.println(k);
        else if (same >= k)
            System.out.println(k + (yours.length()-same));
        else
            System.out.println(same + (yours.length() - k));

        scanner.close();

    }
}
