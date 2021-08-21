import java.util.*;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/functionalfun
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            // Organising input
            scanner.nextLine(); // Domain not needed
            List<String> codomain = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
            codomain.remove(0);
            int n = scanner.nextInt();
            scanner.nextLine();
            List<String> domainMappings = new ArrayList<>();
            List<String> codomainMappings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                domainMappings.add(line[0]);
                codomainMappings.add(line[2]);
            }

            // Find partial function type
            if (new HashSet<>(domainMappings).size() != domainMappings.size()) {
                System.out.println("not a function");
                continue;
            }
            boolean injective = codomainMappings.size() == new HashSet<>(codomainMappings).size(); // No duplicates in codomainMapping
            boolean surjective = codomainMappings.containsAll(codomain);
            if (injective && surjective) {
                System.out.println("bijective");
            } else if (injective) {
                System.out.println("injective");
            } else if (surjective) {
                System.out.println("surjective");
            } else {
                System.out.println("neither injective nor surjective");
            }
        }
        scanner.close();
    }
}
