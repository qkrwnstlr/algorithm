import java.util.*;

class Solution {
    public int solution(int[] numbers, int k) {
        return numbers[(Arrays.binarySearch(numbers, 1) + 2 * (k - 1)) % numbers.length];
    }
}