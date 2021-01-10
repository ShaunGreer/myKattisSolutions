import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);

        int difference1 = nums[2] - nums[1], difference2 = nums[1] - nums[0];
        //The 4th number is the first or last
        if(difference1 == difference2){
            System.out.println(nums[2] + (nums[2] - nums[1]));
        //The 4th number is in position 2
        } else if(nums[1] - difference1 - nums[0] == difference1){
            System.out.println(nums[0] + difference1);
        //The 4th number is in position 3
        } else {
            System.out.println(nums[1] + difference2);
        }
    }
}