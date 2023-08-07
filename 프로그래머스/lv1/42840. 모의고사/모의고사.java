import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] h1 = {1, 2, 3, 4, 5};
        int[] h2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] h3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answer = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(h1[i % h1.length] == answers[i]) answer[0]++;
            if(h2[i % h2.length] == answers[i]) answer[1]++;
            if(h3[i % h3.length] == answers[i]) answer[2]++;
        }
        int max = Arrays.stream(answer).max().getAsInt();
        return IntStream.rangeClosed(1, 3).filter(i -> answer[i - 1] == max).toArray();
    }
}