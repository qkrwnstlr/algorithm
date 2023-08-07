import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            temp.append(String.valueOf(i).repeat(food[i] / 2));
        }
        answer.append(temp.toString());
        answer.append("0");
        answer.append(temp.reverse().toString());
        return answer.toString();
    }
}