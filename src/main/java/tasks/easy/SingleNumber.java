package tasks.easy;

public class SingleNumber {

    public static void main(String[] args) {

    }

    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

}
