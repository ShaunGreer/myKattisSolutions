import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> uniqueCities = new ArrayList<>();
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++){
            int cities = scanner.nextInt();
            for (int j = 0; j < cities; j++){
                String city = scanner.next();
                if (!uniqueCities.contains(city))
                    uniqueCities.add(city);
            }
            System.out.println(uniqueCities.size());
            uniqueCities.clear();
        }
    }
}
