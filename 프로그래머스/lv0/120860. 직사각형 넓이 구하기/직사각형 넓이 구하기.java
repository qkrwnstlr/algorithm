import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int[] temp = Arrays.stream(dots).mapToInt(e -> e[0] + e[1]).sorted().toArray();
        return (temp[3] - temp[1]) * (temp[1] - temp[0]);
    }
}