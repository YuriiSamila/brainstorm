package tasks.easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1}));
    }

    private static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    private static int removeDuplicates2(int[] nums) {
        int temp = nums[0];
        int indexDecrement = 0;
        int lastIndex = nums.length - 1;
        for (int i = 1; i <= nums.length; i++) {
            if (i > lastIndex) {
                break;
            }
            if (nums[i] > temp) {
                temp = nums[i];
            } else {
                for (int j = i; j < lastIndex; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[lastIndex] = 0;
                indexDecrement++;
                lastIndex--;
                i--;
            }
        }
        return nums.length - indexDecrement;
    }

}
