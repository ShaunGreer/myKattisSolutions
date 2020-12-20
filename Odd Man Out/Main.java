
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int guests = scanner.nextInt();
            List<Integer> allGuests = new ArrayList<>(guests);
            for (int j = 0; j < guests; j++) {
                int guest = scanner.nextInt();
                allGuests.add(guest);
            }
            for (int k = 0; k < allGuests.size(); k++) {
                int current = allGuests.get(k);
                if (allGuests.indexOf(current) == allGuests.lastIndexOf(current)) {
                    System.out.println("Case #" + (i + 1) + ": " + current);
                    break;
                }
            }
        }
        scanner.close();
    }
}
