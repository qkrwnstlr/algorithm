import java.util.*;

class Solution {
    public int solution(String before, String after) {
        return Arrays.equals(Arrays.stream(before.split("")).sorted().toArray(), Arrays.stream(after.split("")).sorted().toArray()) ? 1 : 0;
    }
}