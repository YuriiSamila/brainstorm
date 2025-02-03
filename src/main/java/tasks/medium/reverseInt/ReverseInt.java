package tasks.medium.reverseInt;

public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= sign;
        }
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result * 10 > Integer.MAX_VALUE - x % 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = (x - x % 10) / 10;
        }
        return result * sign;
    }

}
