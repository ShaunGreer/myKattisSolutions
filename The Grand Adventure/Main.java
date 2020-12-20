import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> backpack = new Stack<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            backpack.clear();
            boolean no = false;
            String s = scanner.next();
            int a = s.length();
            for (int j = 0; j < a; j++){
                char current = s.charAt(j);
                if (current != '.'){
                    if (isItem(current)) {
                        backpack.push(current);
                    } else {
                        boolean canBeRemoved = removable(backpack, current);
                        if (canBeRemoved)
                            backpack.pop();
                        else {
                            no = true;
                            break;
                        }
                    }
                }
            }
            if (no || backpack.size() > 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        scanner.close();
    }

    private static boolean removable(Stack<Character> bag, char item){
        switch (item){
            case 'b':
                if (bag.isEmpty())
                    return false;
                else if (bag.peek() == '$')
                    return true;
                else
                    return false;
            case 't':
                if (bag.isEmpty())
                    return false;
                else if (bag.peek() == '|')
                    return true;
                else
                    return false;
            case 'j':
                if (bag.isEmpty())
                    return false;
                else if (bag.peek() == '*')
                    return true;
                else
                    return false;
        }
        return false;
    }

    private static boolean isItem (char item){
        switch (item){
            case '$':
            case '|':
            case '*':
                return true;
            default:
                return false;
        }
    }

}
