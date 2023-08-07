import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int[] temp = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).mapToInt(e -> e).toArray();
        return IntStream.range(0, score.length / m).mapToObj(i -> Arrays.copyOfRange(temp, i * m, (i + 1) * m)).mapToInt(e -> e[m - 1] * m).sum();
    }
}