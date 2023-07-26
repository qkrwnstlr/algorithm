import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        return (int) Arrays.stream(s1).filter(e -> Arrays.asList(s2).contains(e)).count();
    }
}