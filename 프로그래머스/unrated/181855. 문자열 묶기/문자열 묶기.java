import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] answer = new int[31];
        for(String s: strArr) answer[s.length()]++;
        return Arrays.stream(answer).max().getAsInt();
    }
}