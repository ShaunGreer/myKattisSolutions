import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = scanner.nextInt();
        int n = scanner.nextInt();
        int peopleOnTrain = 0;

        for (int i = 0; i < n; i++) {
            int toLeave = scanner.nextInt();
            int toEnter = scanner.nextInt();
            int toWait = scanner.nextInt();

            //Check no-one is waiting or enters at the last stop
            if (i == (n-1)){
                if ((toWait > 0) || (toEnter > 0)){
                    System.out.println("impossible");
                    scanner.close();
                    return;
                }
            }

            //Check toLeave doesn't go below 0
            if ((peopleOnTrain - toLeave) < 0){
                System.out.println("impossible");
                scanner.close();
                return;
            }
            peopleOnTrain -= toLeave;

            //Check toEnter doesn't exceed capacity
            if ((peopleOnTrain + toEnter) > capacity) {
                System.out.println("impossible");
                scanner.close();
                return;
            }
            peopleOnTrain += toEnter;

            //Check no-one waited in vein
            if ((peopleOnTrain < capacity) && (toWait > 0)){
                System.out.println("impossible");
                scanner.close();
                return;
            }
        }

        //Check train is empty at end
        if (peopleOnTrain > 0)
            System.out.println("impossible");
        else
            System.out.println("possible");

        scanner.close();
    }

}
