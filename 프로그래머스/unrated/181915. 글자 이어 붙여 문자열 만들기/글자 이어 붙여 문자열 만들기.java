import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for(int i: index_list)answer += Character.toString(my_string.charAt(i));
        return answer;
    }
}