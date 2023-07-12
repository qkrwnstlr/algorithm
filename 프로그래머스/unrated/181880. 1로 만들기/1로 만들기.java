import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).reduce(0, (x, y) -> x + Integer.toBinaryString(y).length() - 1);
    }
}