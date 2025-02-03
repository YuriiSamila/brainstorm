package tasks.easy;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String str) {
        char[] charArray = str.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int j = charArray.length - 1;
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] == charArray[j]) {
                j--;
                continue;
            }
            return false;
        }
        return true;
    }


}
