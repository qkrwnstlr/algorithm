import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).reduce((x,y) -> x * y).getAsInt() > Math.pow(Arrays.stream(num_list).sum(), 2) ? 0 : 1;
    }
}