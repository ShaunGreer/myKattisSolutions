import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rhyme = scanner.nextLine().split(" ");
        ArrayList<String> kids = new ArrayList<>();
        ArrayList<String> team1 = new ArrayList<>();
        ArrayList<String> team2 = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            kids.add(scanner.next());
        }
        int pointer = 0;
        int team = 1;
        while(!kids.isEmpty()){
            if (kids.size() != 1) {
                for (int j = 0; j < rhyme.length-1; j++) {
                    pointer++;
                    if (pointer == kids.size())
                        pointer = 0;
                    else if (pointer > kids.size())
                        pointer = 0 + (pointer - kids.size());
                }
            }
            if (kids.size() == 1)
                pointer = 0;
            if (team == 1) {
                team1.add(kids.get(pointer));
                team = 2;
            } else {
                team2.add(kids.get(pointer));
                team = 1;
            }
            kids.remove(pointer);
        }
        System.out.println(team1.size());
        for(String kid:team1)
            System.out.println(kid);
        System.out.println(team2.size());
        for(String kid:team2)
            System.out.println(kid);
    }
}
