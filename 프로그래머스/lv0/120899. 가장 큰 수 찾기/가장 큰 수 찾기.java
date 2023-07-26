import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array) {
        return (int[]) IntStream.range(0, array.length).mapToObj(e -> new int[]{array[e], e}).sorted((a, b) -> b[0] - a[0]).toArray()[0];
    }
}