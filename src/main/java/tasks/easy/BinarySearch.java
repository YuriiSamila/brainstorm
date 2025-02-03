package tasks.easy;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(getIndex(new int[]{1, 4, 5, 67, 139, 5000}, 5000));
    }

    public static int getIndex(int[] arr, int target) {

        return getIndex(arr, target, 0);
    }

    private static int getIndex(int[] arr, int target, int currentIndex) {
        if (arr.length == 1) {
            if (arr[0] != target) {
                return -1;
            }
            return currentIndex;
        }
        if (arr[arr.length / 2 - 1] == target) {
            return currentIndex + arr.length / 2 - 1;
        }
        if (arr[arr.length / 2 - 1] < target) {
            return getIndex(Arrays.copyOfRange(arr, arr.length / 2, arr.length), target, currentIndex + arr.length / 2);
        }
        return getIndex(Arrays.copyOf(arr, arr.length / 2 - 1), target, 0);
    }

}
