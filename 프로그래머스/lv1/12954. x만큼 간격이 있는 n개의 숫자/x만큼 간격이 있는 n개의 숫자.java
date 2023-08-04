import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(int x, int n) {
        return IntStream.rangeClosed(1, n).mapToLong(e -> (long) e * x).toArray();
    }
}