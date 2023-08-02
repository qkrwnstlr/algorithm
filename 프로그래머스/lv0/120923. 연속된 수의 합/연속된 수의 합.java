import java.util.stream.*;

class Solution {
    public int[] solution(int num, int total) {
        int k = (total - num * (num - 1) / 2) / num;
        return IntStream.range(k , k + num).toArray();
    }
}