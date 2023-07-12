import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList();
        for(int[] interval: intervals)
            for(int i = interval[0]; i <= interval[1]; i ++) answer.add(arr[i]);
        return answer.stream().mapToInt(e -> e).toArray();
    }
}