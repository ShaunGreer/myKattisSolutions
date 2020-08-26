import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] times = new int[6];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            int time = scanner.nextInt();
            times[i] = time;
            if (time < min)
                min = time;
        }
        scanner.close();
        int trucksParked = 0;
        int trucksDone = 0;
        int currentTime = min;
        int total = 0;
        while (trucksDone < 3){
            if (times[0] == currentTime)
                trucksParked++;
            if (times[2] == currentTime)
                trucksParked++;
            if (times[4] == currentTime)
                trucksParked++;
            if (times[1] == currentTime) {
                trucksParked--;
                trucksDone++;
            }
            if (times[3] == currentTime) {
                trucksParked--;
                trucksDone++;
            }
            if (times[5] == currentTime) {
                trucksParked--;
                trucksDone++;
            }
            switch (trucksParked){
                case 1:
                    total += a;
                    break;
                case 2:
                    total += (2 * b);
                    break;
                case 3:
                    total += (3 * c);
                    break;
                default:
            }
            currentTime++;
        }
        System.out.println(total);
    }
}