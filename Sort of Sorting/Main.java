import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while(true){
            List<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                names.add(scanner.next());
            }

            Comp comp = new Comp();
            Collections.sort(names, comp);
            names.forEach(System.out::println);
            n = scanner.nextInt();
            if (n == 0){
                scanner.close();
                return;
            }
            System.out.println();
            names.clear();
        }
    }

    static class Comp implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if (o1.charAt(0) == o2.charAt(0)){
                return o1.charAt(1) - o2.charAt(1);
            }
            return o1.charAt(0) - o2.charAt(0);
        }
    }
}