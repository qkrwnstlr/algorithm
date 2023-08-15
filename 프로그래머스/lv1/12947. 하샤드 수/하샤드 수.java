import java.util.*;
class Solution {
    public boolean solution(int x) {
        return x % Arrays.stream(Integer.toString(x).split("")).mapToInt(Integer::parseInt).sum() == 0;
    }
}