import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> answer = (ArrayList<Integer>)Arrays.stream(arr).distinct().limit(k).boxed().collect(Collectors.toList());
        for(int i = answer.size(); i < k; i++) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
}