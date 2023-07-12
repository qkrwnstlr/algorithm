import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr).filter(e -> !Arrays.stream(delete_list).anyMatch(k -> k == e)).toArray();
    }
}