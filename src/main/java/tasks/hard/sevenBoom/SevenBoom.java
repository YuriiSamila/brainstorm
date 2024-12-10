package tasks.hard.sevenBoom;

/*
Seven Boom!
Create a function that takes an array of numbers and return "Boom!" if the digit 7 appears in the array.
Otherwise, return "there is no 7 in the array".

Examples
sevenBoom([1, 2, 3, 4, 5, 6, 7]) ➞ "Boom!"
// 7 contains the number seven.

sevenBoom([8, 6, 33, 100]) ➞ "there is no 7 in the array"
// None of the items contain 7 within them.

sevenBoom([2, 55, 60, 97, 86]) ➞ "Boom!"
// 97 contains the number seven.
 */

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class SevenBoom {

    private static final int GOAL_DIGIT = 7;

    public static String findSeven(int[] digits) {
        return stream(digits)
                .mapToObj(String::valueOf)
                .filter(s -> s.contains("7"))
                .map(_ -> "Boom!")
                .findAny()
                .orElse("there is no 7 in the array");
    }

    public static String findSevenOwnImpl(int[] digits) {
        boolean thereIsSevenInNumbers = Stream.of(digits)
                .flatMapToInt(Arrays::stream)
                .filter(SevenBoom::check)
                .findAny()
                .isPresent();
        return thereIsSevenInNumbers
                ? "Boom!"
                : "there is no 7 in the array";
    }

    private static boolean check(int integer) {
        int divider = 1;
        boolean isIterationsFinished = false;
        int digit = 0;
        while (true) {
            if (!isIterationsFinished) {
                digit = integer / divider;
                if (digit > 9) {
                    divider *= 10;
                    continue;
                }
                isIterationsFinished = true;
            }
            if (digit == GOAL_DIGIT) {
                return true;
            }
            int subtrahend = digit * divider;
            divider /= 10;
            if (divider == 0) {
                return false;
            }
            digit = (integer -= subtrahend) / divider;
        }
    }

}
