package tasks.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(getMajorityElement(new int[] {2,2,1,1,1,2,2}));
    }

    private static int getMajorityElement(int[] array) {
        Map<Integer, Integer> elementByCount = new HashMap<>();
        int majorityElement = 0;
        int majorityElementCount = 0;
        for (int currentElement : array) {
            Integer value = Optional.ofNullable(elementByCount.get(currentElement)).orElse(0);
            int currentCount = value + 1;
            elementByCount.put(currentElement, currentCount);
            if (currentCount > majorityElementCount) {
                majorityElementCount = currentCount;
                majorityElement = currentElement;
            }
        }
        return majorityElement;
    }

}
