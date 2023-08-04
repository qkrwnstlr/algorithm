import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        List<String> a = Arrays.stream(Long.toString(n).split("")).collect(Collectors.toList());
        Collections.reverse(a);
        return a.stream().mapToInt(Integer::parseInt).toArray();
    }
}