import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] temp = new int[26];
        Arrays.fill(temp, -1);
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(temp[index] == -1) answer[i] = -1;
            else answer[i] = i - temp[index];
            temp[index] = i;
        }
        return answer;
    }
}