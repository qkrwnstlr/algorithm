import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) { 
        String[] answer = Arrays.stream(dic).filter(e -> {
            if(e.length() != spell.length) return false;
            String temp = e;
            for(String s: spell) temp = temp.replaceFirst(s, "");
            return temp.length() == 0;
        }).toArray(String[]::new);
        return answer.length == 0 ? 2 : 1;
    }
}