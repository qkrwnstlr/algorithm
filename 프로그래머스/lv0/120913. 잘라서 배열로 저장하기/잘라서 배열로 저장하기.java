import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(int) Math.ceil((double) my_str.length() / n)];
        for(int i = 0; i < my_str.length(); i++) {
            if(i % n == 0) answer[i / n] = "";
            answer[i / n] += my_str.substring(i, i + 1);
        }
        return answer;
    }
}