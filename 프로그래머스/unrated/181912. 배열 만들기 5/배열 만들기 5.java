import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs).map(e -> Integer.parseInt(e.substring(s, s + l))).filter(e -> e > k).mapToInt(e -> e).toArray();
    }
}