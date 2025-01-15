package algorithms.bobbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] ints = {3, 7, 1, 88, 32, 2, 7, 9};
        System.out.println(Arrays.toString(bubbleSort(ints)));
    }

    private static int[] bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        return ints;
    }

}
