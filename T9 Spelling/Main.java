
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> mapping = getMappings();

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++){
            String output = "Case #" + i + ": ";
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++){
                int val = mapping.get(input.charAt(j));
                if (j == input.length() - 1)
                    output += val;
                else{
                    int nextVal = mapping.get(input.charAt(j+1));
                    if (sameButton(val, nextVal))
                        output += val + " ";
                    else
                        output += val;
                }
            }
            System.out.println(output);
        }
        scanner.close();
    }

    private static HashMap<Character, Integer> getMappings(){
        HashMap<Character, Integer> map = new HashMap<>(27);
        int num = 2;
        int pointer = 1;
        for (int i = 97; i < 123; i++){
            if (i == 115 || i == 122)
                continue;
            else if (pointer == 1)
                map.put((char)i, num);
            else if(pointer == 2)
                map.put((char)i, (num * 10) + num);
            else
                map.put((char)i, (num * 100) + (num * 10) + num);
            pointer++;
            if (pointer > 3) {
                pointer = 1;
                num++;
            }
        }
        map.put('s', 7777);
        map.put('y', 999);
        map.put('z', 9999);
        map.put(' ', 0);
        return map;
    }

    private static boolean sameButton(int value, int nextValue){
        int singleValue = Integer.parseInt(Integer.toString(value).substring(0,1));
        if (nextValue == singleValue
                || nextValue == singleValue * 10 + singleValue
                || nextValue == singleValue * 100 + singleValue * 10 + singleValue
                || nextValue == singleValue * 1000 + singleValue * 100 + singleValue * 10 + singleValue)
            return true;
        return false;
    }
}
