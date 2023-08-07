import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted().sorted(Comparator.comparing(e -> e.charAt(n))).toArray(String[]::new);
    }
}