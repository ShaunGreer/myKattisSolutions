import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //Number of participants
        int b = scanner.nextInt();  //Budget
        int h = scanner.nextInt();  //Number of hotels
        int w = scanner.nextInt();  //Number of weeks to choose from

        ArrayList<Integer> theseHaveEnoughBeds = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            int priceForOne = scanner.nextInt();
            for (int j = 0; j < w; j++) {
                int bedsAvailable = scanner.nextInt();
                if (bedsAvailable >= n){
                    theseHaveEnoughBeds.add(priceForOne);
                }
            }
        }
        Collections.sort(theseHaveEnoughBeds);
        for (int hotel: theseHaveEnoughBeds
             ) {
            if (hotel * n <= b){
                System.out.println(hotel * n);
                return;
            }
        }
        System.out.println("stay home");
    }

}
