import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        Arrays.stream(num_list).forEach(e -> answer[e % 2]++);
        return answer;
    }
}