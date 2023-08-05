import java.util.stream.*;

class Solution {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(e -> a[e] * b[e]).sum();
    }
}