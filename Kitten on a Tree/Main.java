import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> startOfEachLine = new HashMap<>();
        HashMap<String, Integer> valuesInLines = new HashMap<>();
        String current = scanner.nextLine();
        String root = "";
        int count = 1;
        while (true){
            String line = scanner.nextLine();
            if (line.equals("-1"))
                break;
            String[] eachBranchInLine = line.split(" ");
            startOfEachLine.put(count, eachBranchInLine[0]);
            for (int i = 1; i < eachBranchInLine.length; i++) {
                valuesInLines.put(eachBranchInLine[i], count);
            }
            count++;
        }
        scanner.close();
        //Find root
        Collection<String> findingRoot = startOfEachLine.values();
        ArrayList<String> starts = new ArrayList<>(findingRoot);
        for (int i = 0; i < findingRoot.size(); i++) {
            if (!valuesInLines.containsKey(starts.get(i))){
                root = starts.get(i);
                break;
            }
        }
        StringBuilder sb = new StringBuilder(current);
        while (true){
            //Find line current is in
            current = startOfEachLine.get(valuesInLines.get(current));
            sb.append(" ");
            sb.append(current);
            if (current.equals(root)){
                System.out.println(sb.toString());
                return;
            }
        }
    }
}