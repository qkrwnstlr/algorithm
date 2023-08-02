import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        Map<String, List<String>> temp = Arrays.stream(polynomial.replace(" + ", " ").split(" ")).collect(Collectors.groupingBy(e -> e.contains("x") ? "x" : ""));
        String[] keyList = Arrays.stream(temp.keySet().toArray()).sorted(Collections.reverseOrder()).toArray(String[]::new);
        for(int i = 0; i < keyList.length; i++) {
            String key = keyList[i];
            answer += temp.get(key).stream().map(e -> e.replace(key, "")).map(e -> e.equals("") ? "1" : e).mapToInt(Integer::parseInt).reduce(0, Integer::sum) + key;
            if(answer.equals("1x")) answer = "x";
            if(i != keyList.length - 1) answer += " + ";
        }
        return answer;
    }
}