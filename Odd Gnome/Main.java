import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i =0; i < n; i++){
            int g = scanner.nextInt();
            ArrayList<Integer> gnomes = new ArrayList<>(g);
            for (int j = 0; j < g; j++){
                int gnome = scanner.nextInt();
                gnomes.add(gnome);
            }
            for (int k = 0; k < gnomes.size()-1; k++){
                int gnome1 = gnomes.get(k);
                int gnome2 = gnomes.get(k + 1);
                if (gnome2 != (gnome1 + 1)) {
                    System.out.println(k+2);
                    break;
                }
            }
        }
        scanner.close();
    }
}
