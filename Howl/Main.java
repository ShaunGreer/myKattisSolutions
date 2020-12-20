import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String fenrir = scanner.next();
        StringBuilder myHowl = new StringBuilder();
        for (int i = 0; i < fenrir.length()-2; i++){
            myHowl.append("AW");
        }
        myHowl.append("HOO");
        System.out.println(myHowl.toString());
    }
}
