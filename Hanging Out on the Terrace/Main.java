
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();  //People limit
        int events = scanner.nextInt(); //Number of events
        int currentTotal = 0;   //Number of people currently on rooftop
        int rejected = 0;

        for (int i = 0; i < events; i++){
            String type = scanner.next();
            int numberOfPeople = scanner.nextInt();
            if (type.equals("enter")){
                if ((currentTotal + numberOfPeople) > l)
                    rejected++;
                else
                    currentTotal+= numberOfPeople;
            } else if (type.equals("leave"))
                currentTotal -= numberOfPeople;
            
        }
        System.out.println(rejected);
    }
}
