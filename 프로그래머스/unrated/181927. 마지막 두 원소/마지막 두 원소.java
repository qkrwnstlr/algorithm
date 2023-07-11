import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> answer = new ArrayList();
        int n = num_list[num_list.length - 1];
        int m = num_list[num_list.length - 2];
        for(int i : num_list) answer.add(i);
        answer.add(n > m ? n - m : n * 2);
        return answer.stream().mapToInt(x -> x).toArray();
    }
}