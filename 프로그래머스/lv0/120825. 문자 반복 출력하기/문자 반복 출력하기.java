import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(my_string.split("")).forEach(e -> {
            for(int i = 0; i < n; i++) sb.append(e);
        });
        return sb.toString();
    }
}