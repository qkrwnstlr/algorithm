import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining()).replaceAll("[^7]", "").length();
    }
}