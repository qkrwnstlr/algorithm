import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, List<Integer>> temp = Arrays.stream(new int[]{a, b, c, d}).boxed().collect(Collectors.groupingBy(e -> e));
        int[] keys = Arrays.stream(temp.keySet().toArray()).sorted(Comparator.comparingInt(x -> temp.get(x).size())).mapToInt(e -> (int) e).toArray();
        if (keys.length == 1) return 1111 * a;
        if (keys.length == 2) {
            if (temp.get(keys[0]).size() == 2) return (keys[0] + keys[1]) * Math.abs(keys[0] - keys[1]);
            return (int) Math.pow(10 * keys[1] + keys[0], 2);
        }
        if (keys.length == 3) return keys[0] * keys[1];
        return keys[0];
    }
}