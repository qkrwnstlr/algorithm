import java.util.*;

class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(String s : control.split("")) {
            switch(s) {
                case "w": answer += 1; break;
                case "s": answer -= 1; break;
                case "d": answer += 10; break;
                case "a": answer -= 10; break;
            }
        }
        return answer;
    }
}