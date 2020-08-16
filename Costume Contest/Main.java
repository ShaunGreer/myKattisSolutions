import java.util.*;

public class Main{
    public static void main(String[] args){
        //Get input
        Scanner scanner = new Scanner(System.in);
        int numberOfColleagues = scanner.nextInt();
        HashMap<String, Integer> costumesInCategories = new HashMap<>();
        HashSet<String> uniqueCategories = new HashSet<>();
        for (int i = 0; i < numberOfColleagues; i++) {
            String category = scanner.next();
            if (!costumesInCategories.containsKey(category)){
                costumesInCategories.put(category, 1);
            } else {
                int costumes = costumesInCategories.get(category);
                costumesInCategories.put(category, costumes+1);
            }
            uniqueCategories.add(category);
        }
        scanner.close();

        //Calculate result
        int smallest = Collections.min(costumesInCategories.values());
        List<String> bestOptions = new ArrayList<>();
        for (String s: uniqueCategories
             ) {
            if (costumesInCategories.get(s) == smallest)
                bestOptions.add(s);
        }

        if (bestOptions.size() == 1)
            System.out.println(bestOptions.get(0));
        else {
            Collections.sort(bestOptions);
            for (String s: bestOptions
                 ) {
                System.out.println(s);
            }
        }
    }
}