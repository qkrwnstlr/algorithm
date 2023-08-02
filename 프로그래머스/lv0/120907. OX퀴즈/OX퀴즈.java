import java.util.*;

class Solution {
    public static String[] solution(String[] quiz) {
        List<String> answer = new ArrayList<>();
        String[][] temps = Arrays.stream(quiz).map(e -> Arrays.stream(e.split(" ")).toArray(String[]::new)).toArray(String[][]::new);
        for(String[] temp : temps) {
            if(temp[1].equals("+")) {
                if(Integer.parseInt(temp[0]) + Integer.parseInt(temp[2]) == Integer.parseInt(temp[4])) answer.add("O");
                else answer.add("X");
            } else {
                if(Integer.parseInt(temp[0]) - Integer.parseInt(temp[2]) == Integer.parseInt(temp[4])) answer.add("O");
                else answer.add("X");
            }
        }
        return answer.toArray(String[]::new);
    }
}