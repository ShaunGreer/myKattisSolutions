import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String month = scanner.next();
            int day = scanner.nextInt();
            int year = scanner.nextInt();
            String sunrise = scanner.next();
            String sunset = scanner.next();

            int sunriseHour = Integer.parseInt(sunrise.split(":")[0]);
            int sunriseMin = Integer.parseInt(sunrise.split(":")[1]);
            int sunsetHour = Integer.parseInt(sunset.split(":")[0]);
            int sunsetMin = Integer.parseInt(sunset.split(":")[1]);

            int hoursOfSun = 0;
            int minsOfSun = 0;
            if (sunriseMin > sunsetMin) {
                hoursOfSun = sunsetHour - sunriseHour - 1;
                minsOfSun = (60 - sunriseMin) + sunsetMin;
            } else {
                hoursOfSun = sunsetHour - sunriseHour;
                minsOfSun = sunsetMin - sunriseMin;
            }

            System.out.println(month + " " + day + " " + year + " "
                    + hoursOfSun + " hours " + minsOfSun + " minutes");
        }
        scanner.close();
    }
}