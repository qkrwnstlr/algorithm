import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        IntStream.range(0, num_list.length).boxed().filter(i -> i % n == 0).forEach(i -> answer[i / n] =Arrays.copyOfRange(num_list, i, i + n));
        return answer;
    }
}