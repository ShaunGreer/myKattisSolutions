import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<String> allLines = new ArrayList<>();

        while (scanner.hasNext()){
            allLines.add(scanner.nextLine());
        }

        Comparator<String> byLen = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        String last = allLines.get(allLines.size()-1);
        allLines.sort(byLen);
        int n = allLines.get(allLines.size()-1).length();
        allLines.remove(last);

        int total = 0;
        for (String s:allLines
             ) {
            total += Math.pow(n - s.length(), 2);
        }
        System.out.println(total);

        scanner.close();
    }

}
