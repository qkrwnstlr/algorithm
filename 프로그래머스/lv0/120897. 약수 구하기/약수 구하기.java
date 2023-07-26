import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList();
        for(int i = 1; i * i <= n; i++) {
            if(i * i == n) answer.add(i);
            else if(n % i == 0) {
                answer.add(i);
                answer.add(n / i);
            }
        }
        return answer.stream().sorted().mapToInt(e -> e).toArray();
    }
}