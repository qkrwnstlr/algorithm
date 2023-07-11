import java.util.*;

class Solution {
    public int solution(String num_str) {
        return Arrays.stream(num_str.split("")).map(Integer::parseInt).reduce(Integer::sum).get();
    }
}