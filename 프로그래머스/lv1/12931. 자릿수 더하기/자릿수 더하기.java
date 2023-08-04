import java.util.*;

public class Solution {
    public int solution(int n) {
        return Arrays.stream(Integer.toString(n).split("")).mapToInt(e -> Integer.parseInt(e)).sum();
    }
}