import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        return IntStream.rangeClosed(i, j).boxed().map(e -> Integer.toString(e)).collect(Collectors.joining()).replaceAll("[^" + k + "]", "").length();
    }
}