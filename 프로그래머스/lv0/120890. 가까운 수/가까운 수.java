import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int n) {
        Map<Integer, List<Integer>> temp = Arrays.stream(array).sorted().boxed().collect(Collectors.groupingBy(e -> Math.abs(e - n)));
        return temp.get(temp.keySet().stream().sorted().toArray()[0]).get(0);
    }
}