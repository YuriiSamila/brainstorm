package tasks.medium.digitsNumber;

import java.time.Duration;
import java.time.LocalTime;

import static java.time.LocalTime.now;

public class OnesNumber {

    public static void main(String[] args) {
        System.out.println(countOnes(161));
    }

    private static int countOnes(int num) {
        LocalTime startTime = now();
        int result = 0;
        int divider = 10;
        for (int i = 0; i <= num; i++) {
            int higherOrderDigit = i / divider;
            result = incrementAndReturnResult(higherOrderDigit, result);
            int lowerOrderDigit = i - higherOrderDigit * divider;
            result = incrementAndReturnResult(lowerOrderDigit, result);
            if (i / divider >= 10) {

                divider *= 10;
            }
        }
        LocalTime endTime = now();
        System.out.println("Total time: " + Duration.between(startTime, endTime).toMillis());
        return result;
    }

    private static int incrementAndReturnResult(int digit, int currentResult) {
        return digit == 1
                ? ++currentResult
                : currentResult;
    }

}
