import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(i -> Math.sqrt(i) - (int) Math.sqrt(i) == 0 ? -i : i).sum();
    }
}