import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypted = scanner.next();
        String key = scanner.next();
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            int toShift = (encrypted.charAt(i));
            int shiftValue = (int)(key.charAt(i)) - 65;
            if (i % 2 != 0){
                if ((toShift + shiftValue) > 90) {
                    int difference = Math.abs(90 - (toShift + shiftValue));
                    decrypted.append((char)(64 + difference));
                } else
                    decrypted.append((char)((toShift) + shiftValue));
            } else {
                if ((toShift - shiftValue) < 65){
                    int difference = Math.abs(65 - (toShift - shiftValue));
                    decrypted.append((char)(91 - difference));
                } else
                    decrypted.append((char)((toShift) - shiftValue));
            }
        }
        System.out.println(decrypted);
    }
}