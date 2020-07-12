import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){
            int daysInYear = scanner.nextInt();
            int monthsInYear = scanner.nextInt();
            int[] daysOfEachMonth = new int[monthsInYear];
            for (int j = 0; j < monthsInYear; j++){
                daysOfEachMonth[j] = scanner.nextInt();
            }
            String day = "Sunday";
            int date = 1;
            int dayCounter = 1;
            int monthCounter = 0;
            int result = 0;
            while(dayCounter <= daysInYear){
                if (date == 13 && day.equals("Friday")){
                    result++;
                }
                day = nextDay(day);
                dayCounter++;
                date++;
                if (date > daysOfEachMonth[monthCounter]) {
                    date = 1;
                    monthCounter++;
                }

            }
            System.out.println(result);
        }

        scanner.close();
    }

    private static String nextDay (String day){
        switch (day){
            case "Sunday":
                return "Monday";
            case "Monday":
                return "Tuesday";
            case "Tuesday":
                return "Wednesday";
            case "Wednesday":
                return "Thursday";
            case "Thursday":
                return "Friday";
            case "Friday":
                return "Saturday";
            default:
                return "Sunday";
        }
    }
}