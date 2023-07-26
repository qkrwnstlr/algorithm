import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(String s  : my_string.split("")) if(sb.indexOf(s) == -1) sb.append(s);
        return sb.toString();
    }
}