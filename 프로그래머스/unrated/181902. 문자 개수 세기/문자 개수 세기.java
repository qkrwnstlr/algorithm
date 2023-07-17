import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        my_string.chars().forEach(c -> {if(c < 97)answer[c - 'A']++; else answer[26 + c - 'a']++;});
        return answer;
    }
}