package tasks.expert.kaprekarsConstant;

import java.util.List;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Stream.of;

public class KaprekarsConstant {

    private static final int KARPEKARS_NUMBER = 6174;

    public static int kaprekarsConstant(int number, int iteration) {
        if (number < 1000) {
            number *= 10;
        }
        int firstDigit = number / 1000;
        int thousands = 1000 * firstDigit;
        int secondDigit = (number - thousands) / 100;
        int hundreds = 100 * secondDigit;
        int thirdDigit = (number - (thousands + hundreds)) / 10;
        int fourthDigit = number - (thousands + hundreds + 10 * thirdDigit);
        List<Integer> naturalOrderDigits = of(firstDigit, secondDigit, thirdDigit, fourthDigit)
                .sorted()
                .toList();
        boolean isNumberIncorrect = naturalOrderDigits.
                stream().
                distinct().
                toList().
                size() < 2;
        if (isNumberIncorrect) {
            throw new RuntimeException("A number with the all same digits is not allowed");
        }
        List<Integer> reversedDigits = naturalOrderDigits.stream()
                .sorted(reverseOrder())
                .toList();
        int biggerNumber = sortDigits(reversedDigits);
        int lowerNumber = sortDigits(naturalOrderDigits);
        int result = biggerNumber - lowerNumber;
        iteration++;
        if (result != KARPEKARS_NUMBER) {
            return kaprekarsConstant(result, iteration);
        }
        return iteration;
    }

    private static int sortDigits(List<Integer> digits) {
        int number = 0;
        int multiplier = 1000;
        for (Integer digit : digits) {
            number += digit * multiplier;
            multiplier /= 10;
        }
        return number;
    }

}
