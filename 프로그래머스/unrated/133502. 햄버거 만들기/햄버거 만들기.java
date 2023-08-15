import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> temp = new Stack<>();
        for(int i : ingredient) {
            temp.push(i);
            if(temp.size() >= 4 && temp.get(temp.size() - 1) == 1 && temp.get(temp.size() - 2) == 3 && temp.get(temp.size() - 3) == 2 && temp.get(temp.size() - 4) == 1) {
                answer++;
                for(int j = 0; j < 4; j++) temp.pop();
            }
        }
        return answer;
    }
}