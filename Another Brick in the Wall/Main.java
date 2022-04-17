import java.util.Scanner;

/**
 * @author Shaun Greer
 * Reference: https://open.kattis.com/problems/anotherbrick
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int currentWidth = 0;
        int currentHeight = 1;
        boolean scanForNextBrick = true; // Don't read new brick when moving up a level in the wall
        int lastSourcedBrick = 0; // Track last read brick when moving up a level in the wall

        for (int i = 0; i < n; i++) {
            int brick;
            if (scanForNextBrick) {
                brick = scanner.nextInt();
            } else {
                brick = lastSourcedBrick;
                i--;
                scanForNextBrick = true;
            }
            if ((currentWidth + brick) <= w) {
                currentWidth += brick;
            } else { // Next level of the wall
                if (currentHeight == h && currentWidth == w) { // Done
                    System.out.println("YES");
                    return;
                } else if (currentWidth != w && currentWidth != 0) { // Given up
                    System.out.println("NO");
                    return;
                } else { // Move to next level of the wall
                    currentHeight++;
                    currentWidth = 0;
                    scanForNextBrick = false;
                    lastSourcedBrick = brick;
                    if (currentHeight > h) { // Done
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        if (currentHeight == h && currentWidth == w) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
