
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.next();
        String m = scanner.next();
        int nLength = n.length();
        int mLength = m.length();

        if (nLength > mLength){
            for (int i = 0; i < nLength - mLength; i++){
                m = "_" + m;
            }
        } else if (mLength > nLength){
            for (int i = 0; i< (mLength - nLength); i++){
                n = "_" + n;
            }
        }

        StringBuilder newN = new StringBuilder("");
        StringBuilder newM = new StringBuilder("");

        for (int i = 0; i < m.length(); i++) {
            char currentM = m.charAt(i);
            char currentN = n.charAt(i);
            if (currentM == '_')
                newN.append(currentN);
            else if (currentN == '_')
                newM.append(currentM);
            else{
                if ((currentM - '0') == (currentN - '0')){
                    newM.append(currentM);
                    newN.append(currentN);
                } else if ((currentM - '0') > (currentN - '0'))
                    newM.append(currentM);
                else
                    newN.append(currentN);
            }
        }

        if (newN.toString().equals(""))
            System.out.println("YODA");
        else
            System.out.println(Integer.parseInt(newN.toString()));

        if (newM.toString().equals(""))
            System.out.println("YODA");
        else
            System.out.println(Integer.parseInt(newM.toString()));

        scanner.close();
    }
}
