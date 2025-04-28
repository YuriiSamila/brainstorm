package tasks.medium.interleavingString;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(interleavingString2("aa", "ab", "aaba"));
    }

    private static boolean interleavingString(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        int k = 0;
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        while (i < s3.length()) {
            boolean matched = false;
            if (s1.length() > j && s1.charAt(j) == s3.charAt(i)) {
                j++;
                i++;
                matched = true;
                continue;
            }
            while (s2.length() > k && s2.charAt(k) == s3.charAt(i)) {
                k++;
                i++;
                matched = true;
            }
            if (!matched) {
                return false;
            }
//            if ((s1.isEmpty() || s1.length() > j && s1.charAt(j) != s3.charAt(i)) &&
//                    (s2.isEmpty() || s2.length() > k && s2.charAt(k) != s3.charAt(i))) {
//                return false;
//            }

        }
        return j + k == s3.length();
    }

    private static boolean interleavingString2(String s1, String s2, String s3) {
        String concat = s1.concat(s2);
        Map<Character, Long> characterLongMap = concat.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()));
        Map<Character, Long> resultMap = s3.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), TreeMap::new, counting()));
        return resultMap.entrySet().stream()
                .allMatch(entry -> Objects.equals(entry.getValue(), characterLongMap.get(entry.getKey())));
    }

}
