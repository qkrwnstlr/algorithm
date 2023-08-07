import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = Arrays.stream(dartResult.split("[S|DT*#]")).filter(e -> !e.equals("")).mapToInt(Integer::parseInt).toArray();
        String[] areas = Arrays.stream(dartResult.split("[0-9]")).filter(e -> !e.equals("")).toArray(String[]::new);
        int[] answer = new int[scores.length];
        for(int i = 0; i < answer.length; i++) {
            String[] temp = areas[i].split("");
            switch(temp[0]) {
                case "S": answer[i] = scores[i]; break;
                case "D": answer[i] = (int) Math.pow(scores[i], 2); break;
                case "T": answer[i] = (int) Math.pow(scores[i], 3); break;
            }
            if(temp.length == 1) continue;
            switch(temp[1]) {
                case "*": if(i > 0) answer[i - 1] = answer[i - 1] * 2; answer[i] = answer[i] * 2; break;
                case "#": answer[i] = -answer[i];
            }
        }
        return Arrays.stream(answer).sum();
    }
}