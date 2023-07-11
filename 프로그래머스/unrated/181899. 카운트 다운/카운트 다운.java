import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end) {
        return IntStream.range(end, start + 1).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();
    }
}