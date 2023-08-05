import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        List<String> numbers = Arrays.stream((new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"})).collect(Collectors.toList());
        StringBuilder answer = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp >= '0' && temp <= '9') answer.append(temp);
            else {
                current.append(temp);
                if(numbers.contains(current.toString())) {
                    answer.append(numbers.indexOf(current.toString()));
                    current.setLength(0);
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
}