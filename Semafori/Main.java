import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int seconds = 0;
        int distance= 0;
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            seconds += d - distance;
            distance = d;
            if (seconds < r){
                while (seconds < r)
                    seconds++;
            } else {
                int trafficLightTime = 0;
                boolean redLight = true;
                while (true){
                    if (redLight){
                        if ((trafficLightTime + r) > seconds) {
                            trafficLightTime += r;
                            while (seconds < trafficLightTime)
                                seconds ++;
                            break;
                        } else
                            trafficLightTime += r;
                    } else {
                        if ((trafficLightTime + g) > seconds)
                            break;
                        else
                            trafficLightTime += g;
                    }
                    redLight = !redLight;
                }
            }
        }
        System.out.println(seconds + (l - distance));
    }
}