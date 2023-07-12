import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList();
        int current = n;
        while(current != 1) {
            answer.add(current);
            if(current % 2 == 0) current /= 2;
            else current = current * 3 + 1;
        }
        answer.add(1);
        return answer.stream().mapToInt(e -> e).toArray();
    }
}