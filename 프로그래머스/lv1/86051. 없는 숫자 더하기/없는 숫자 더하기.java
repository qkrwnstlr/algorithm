import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> temp = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        return IntStream.range(0, 10).filter(e -> !temp.contains(e)).sum();
    }
}