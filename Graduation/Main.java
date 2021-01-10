import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        //Create a collection of classes
        List<Character> classes = new ArrayList<>(k);
        char currentClass = 'A';
        for(int i = 0; i < k; i++){
            classes.add(currentClass);
            currentClass++;
        }

        //Read and format students
        char[][] students = new char[n][m];
        for(int i = 0; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < m; j++){
                students[i][j] = line.charAt(j);
            }
        }

        //Go through each column and remove class
        int colours = 0;
        for(int i = 0; i < m; i++){
            List<Character> temp = new ArrayList<>(k);
            for(int j = 0; j < n; j++){
                if(classes.contains(students[j][i])){
                    classes.remove(Character.valueOf(students[j][i]));
                    temp.add(students[j][i]);
                }
            }
            for(int j = 0; j < n; j++){
                if(!temp.contains(students[j][i])){
                    colours--;
                    break;
                }
            }
            colours++;
        }
        System.out.println(colours);
        sc.close();
    }
}