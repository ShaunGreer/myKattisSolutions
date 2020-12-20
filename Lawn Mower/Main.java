import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            //***Read input***
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Double w = scanner.nextDouble();
            //Check if end of input
            if (x == 0 && y == 0 && w == 0.0){
                scanner.close();
                return;
            }
            Double[] widthCuts = new Double[x];
            Double[] lengthCuts = new Double[y];
            for (int i = 0; i < x; i++) {
                widthCuts[i] = scanner.nextDouble();
            }
            for (int i = 0; i < y; i++) {
                lengthCuts[i] = scanner.nextDouble();
            }

            Arrays.sort(widthCuts);
            Arrays.sort(lengthCuts);
            System.out.println(checkGoodJob(widthCuts, lengthCuts, w));
        }
    }

    private static String checkGoodJob(Double[] widthCuts, Double[] lenghtCuts, Double w){
        for (int i = 0; i < widthCuts.length-1; i++) {
            if (Double.compare((widthCuts[i+1] - widthCuts[i]), w) > 0)
                return "NO";
        }
        if (Double.compare(widthCuts[widthCuts.length-1] + (w/2), 75.0) < 0)
            return "NO";

        for (int i = 0; i < lenghtCuts.length-1; i++) {
            if (Double.compare((lenghtCuts[i+1] - lenghtCuts[i]), w) > 0)
                return "NO";
        }
        if (Double.compare(lenghtCuts[lenghtCuts.length-1] + (w/2), 100.0) < 0)
            return "NO";
        return "YES";
    }
}