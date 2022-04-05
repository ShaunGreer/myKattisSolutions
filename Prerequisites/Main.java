import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/prerequisites
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k;
        while ((k = scanner.nextInt()) != 0) {
            int m = scanner.nextInt();
            scanner.nextLine();
            List<String> coursesChosen = Arrays.asList(scanner.nextLine().split(" "));
            boolean failedToMeet = false;
            for (int i = 0; i < m; i++) {
                scanner.nextInt(); // Don't need variable c
                int r = scanner.nextInt();
                String[] coursesRequired = scanner.nextLine().trim().split(" ");
                if (failedToMeet) { // Already failed to meet the requirements, can't break as need to read input
                    continue;
                }
                int coursesMet = 0;
                for (String requiredCourse: coursesRequired) {
                    if (coursesChosen.contains(requiredCourse)) {
                        coursesMet++;
                        if (coursesMet >= r) {
                            break;
                        }
                    }
                }
                if (coursesMet < r) {
                    failedToMeet = true;
                }
            }
            if (!failedToMeet) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }
}
