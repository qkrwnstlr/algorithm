import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] temp = my_string.split(" ");
        int answer = Integer.parseInt(temp[0]);
        for(int i = 1; i < temp.length; i += 2) {
            if(temp[i].equals("+")) answer += Integer.parseInt(temp[i + 1]);
            else answer -= Integer.parseInt(temp[i + 1]);
        }
        return answer;
    }
}