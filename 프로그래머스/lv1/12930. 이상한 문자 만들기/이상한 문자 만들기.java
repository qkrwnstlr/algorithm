import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String temp : s.split("")) {
            if(temp.equals(" ")) {
                sb.append(temp);
                i = 0;
                continue;
            }
            if(i % 2 == 0) sb.append(temp.toUpperCase());
            else sb.append(temp.toLowerCase());
            i++;
        }
        return sb.toString();
    }
}