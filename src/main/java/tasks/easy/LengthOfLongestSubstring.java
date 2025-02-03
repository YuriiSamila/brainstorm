package tasks.easy;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("ssdkvkwpwpwodoonnbbdsseprc;mnvsflkj"));
    }

    public static int getLengthOfLongestSubstring(String string) {
        char[] charArray = string.toCharArray();
        char[] result = new char[charArray.length];
        int bestResult = 1;
        int currentResult = 1;
        for (int i = 0; i < charArray.length; i++) {
            result[i] = charArray[i];
            for (int j = i + 1; j < charArray.length; j++) {
                if (!contains(result, charArray[j])) {
                    result[j] = charArray[j];
                    currentResult++;
                    if (currentResult > bestResult) {
                        bestResult = currentResult;
                    }
                } else {
                    result = new char[charArray.length];
                    currentResult = 1;
                    break;
                }
            }
        }
        return bestResult;
    }

    private static boolean contains(char[] currentResult, char currentChar) {
        for (char c : currentResult) {
            if (c == currentChar) {
                return true;
            }
        }
        return false;
    }

}
