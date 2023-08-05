import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList();
        int before = arr[0];
        answer.add(before);
        for(int current : arr) {
            if(before == current) continue;
            answer.add(before = current);
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
}