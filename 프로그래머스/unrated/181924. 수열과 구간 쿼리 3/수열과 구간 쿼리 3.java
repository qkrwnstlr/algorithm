import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Arrays.stream(queries).forEach(e -> {
            Collections.swap(answer, e[0], e[1]);
        });
        return answer.stream().mapToInt(e -> e).toArray();
    }
}