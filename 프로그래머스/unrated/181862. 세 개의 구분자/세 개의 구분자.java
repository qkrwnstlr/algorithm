import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.replaceAll("[a-c]", " ").split(" ")).filter(e -> !e.equals("")).toArray(String[]::new);
        String[] empty = {"EMPTY"};
        return answer.length == 0 ? empty : answer;
    }
}