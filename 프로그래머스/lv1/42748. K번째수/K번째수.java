import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands).mapToInt(e -> Arrays.stream(Arrays.copyOfRange(array, e[0] - 1, e[1])).sorted().toArray()[e[2] - 1]).toArray();
    }
}