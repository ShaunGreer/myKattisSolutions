import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int s0 = scanner.nextInt();
            int s1 = scanner.nextInt();
            int r0 = scanner.nextInt();
            int r1 = scanner.nextInt();

            //End of input
            if (s0 == 0)
                return;

            //Check if any are highest e.g. 12  or 21
            if (isHighest(s0, s1) && !isHighest(r0, r1)) {
                System.out.println("Player 1 wins.");
                continue;
            }
            else if (!isHighest(s0, s1) && isHighest(r0, r1)) {
                System.out.println("Player 2 wins.");
                continue;
            }
            else if (isHighest(s0,s1) && isHighest(r0,r1)) {
                System.out.println("Tie.");
                continue;
            }

            //Check if any are doubles
            if (isDouble(s0,s1) && !isDouble(r0,r1)){
                System.out.println("Player 1 wins.");
                continue;
            }
            else if (!isDouble(s0,s1) && isDouble(r0,r1)){
                System.out.println("Player 2 wins.");
                continue;
            }
            else if (isDouble(s0,s1) && isDouble(r0,r1)){
                if (checkHighestDouble(s0, r0).equals("p1")){
                    System.out.println("Player 1 wins.");
                    continue;
                }
                else if (checkHighestDouble(s0, r0).equals("p2")){
                    System.out.println("Player 2 wins.");
                    continue;
                }
                else if (checkHighestDouble(s0, r0).equals("both")){
                    System.out.println("Tie.");
                    continue;
                }
            }

            //Other rolls
            String player1 = makeLargest(s0,s1);
            String player2 = makeLargest(r0,r1);
            if (Integer.parseInt(player1) > Integer.parseInt(player2))
                System.out.println("Player 1 wins.");
            else if (Integer.parseInt(player1) < Integer.parseInt(player2))
                System.out.println("Player 2 wins.");
            else
                System.out.println("Tie.");
        }
        scanner.close();
    }

    private static String makeLargest(int roll1, int roll2){
        String largest = "";
        if (roll1 > roll2)
            largest += roll1 + "" + roll2;
        else
            largest += roll2 + "" + roll1;
        return largest;
    }

    private static String checkHighestDouble(int roll1, int roll2){
        if (roll1 > roll2)
            return "p1";
        else if (roll1 < roll2)
            return "p2";
        else
            return "both";
    }

    private static boolean isDouble(int roll1, int roll2){
        return roll1 == roll2;
    }

    private static boolean isHighest(int roll1, int roll2){
        return (((roll1 == 1) && (roll2 == 2)) || ((roll2 == 1) && (roll1 == 2)));
    }

}
