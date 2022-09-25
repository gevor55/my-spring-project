import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 1, 7, 5};
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int number = x;
        int reverse = 0;
        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return x == reverse;
    }
}
