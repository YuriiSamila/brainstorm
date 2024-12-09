package tasks.medium.arrayOfMultiples;

/* Array of Multiples
Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num
until the array length reaches length */

public class ArrayOfMultiples {

    public static int[] arrayOfMultiples(int num, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (i + 1) * num;
        }
        return array;
    }

}
