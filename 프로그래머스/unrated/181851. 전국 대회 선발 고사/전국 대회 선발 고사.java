import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
    return IntStream.range(0, rank.length).filter(i -> attendance[i]).boxed().sorted(Comparator.comparingInt(a -> rank[a])).limit(3).mapToInt(e -> e).reduce(0, (a, b) -> a * 100 + b);

    }
}