import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] eachWord = line.split(" ");
            List<Integer>numbers = new ArrayList<>();
            for (String s:eachWord
                 ) {
                numbers.add(Integer.valueOf(s));
            }
            for (int i = 0; i < numbers.size() ; i++) {
                int current = numbers.get(i);
                numbers.set(i, 0);
                if (current == (sum(numbers))){
                    System.out.println(current);
                    break;
                } else {
                    numbers.set(i, current);
                }
            }
        }
        scanner.close();
    }

    private static int sum(List<Integer> numbers){
        int sum = 0;
        for (int num:numbers
             ) {
            sum += num;
        }
        return sum;
    }
}