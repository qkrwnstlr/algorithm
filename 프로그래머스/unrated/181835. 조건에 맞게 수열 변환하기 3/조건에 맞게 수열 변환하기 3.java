import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = Arrays.stream(arr).map(i -> k % 2 == 0 ? i + k : i * k).toArray();
        return answer;
    }
}