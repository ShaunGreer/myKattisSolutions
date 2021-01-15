import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(s1);
            System.out.println(s2);
            for(int j = 0; j < s1.length(); j++){
                if(s1.charAt(j) != s2.charAt(j))
                    System.out.print('*');
                else
                    System.out.print('.');
            }
            System.out.println('\n');
        }

        scanner.close();
    }

}