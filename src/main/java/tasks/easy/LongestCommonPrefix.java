package tasks.easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(getLongestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    private static String getLongestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder(strs[0]);
        StringBuilder tempResult = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {
            String str1 = strs[i];
            //String str2 = strs[i + 1];
            int min = Math.min(str1.length(), result.length());
            for (int j = 0; j < min; j++) {
                if (str1.charAt(j) == result.charAt(j)) {
                    tempResult.append(str1.charAt(j));
                } else {
                    break;
                }
            }
            result = tempResult;
            tempResult = new StringBuilder();
        }
        return result.toString();
    }

    private static String getLongestCommonPrefix2(String[] strs) {
        Arrays.sort(strs, Comparator.comparing(String::length).reversed());
        String longestPrefix = strs[0];
        for (int j = 1; j < strs.length; j++) {
            longestPrefix = getPrefix(longestPrefix, strs[j]);
        }
        return longestPrefix;
    }

    private static String getPrefix(String longestPrefix, String currentWord) {
        StringBuilder result = new StringBuilder();
        char[] longestPrefixCharArray = longestPrefix.toCharArray();
        char[] currentWordCharArray = currentWord.toCharArray();
        int charsLength = Math.min(currentWordCharArray.length, longestPrefixCharArray.length);
        for (int i = 0; i < charsLength; i++) {
            char currentWordChar = currentWordCharArray[i];
            if (currentWordChar == longestPrefixCharArray[i]) {
                result.append(currentWordChar);
            } else {
                break;
            }
        }
        return result.toString();
    }

}
