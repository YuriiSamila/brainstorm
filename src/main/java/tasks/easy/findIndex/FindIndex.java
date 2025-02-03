package tasks.easy.findIndex;

public class FindIndex {

    public static void main(String[] args) {
        System.out.println(findIndex("sadbutsad", "sad"));
    }

    private static int findIndex(String haystack, String needle) {
        int needleLength = needle.length();
        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
