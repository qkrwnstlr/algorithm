import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).reduce(0, (x , y) -> included[y] ? x + a + d * y : x);
    }
}