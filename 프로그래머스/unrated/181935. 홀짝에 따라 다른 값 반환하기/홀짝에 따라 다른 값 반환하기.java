import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if(n % 2 == 1) {
            return IntStream.range(1, n + 1).filter(e -> e % 2 == 1).reduce(Integer::sum).getAsInt();
        } else {
            return IntStream.range(1, n + 1).filter(e -> e % 2 == 0).reduce(0, (x, y) -> x + y * y);
        }
    }
}