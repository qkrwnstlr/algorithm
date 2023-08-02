import java.util.*;
class Solution {
    public long solution(String numbers) {
        List<String> strings = new ArrayList<String>(List.of(new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}));

        String temp = "";
        String answer = "";
        for(String s : numbers.split("")) {
            if(strings.contains(temp)) {
                answer += strings.indexOf(temp);
                temp = "";
            }
            temp += s;
        }
        if(strings.contains(temp)) answer += strings.indexOf(temp);
        return Long.parseLong(answer);
    }
}