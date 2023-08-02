import java.util.*;

class Solution {
    int N;
    public int[] solution(int[] numlist, int n) {
        N = n;
        return Arrays.stream(numlist).mapToObj(e -> new Int(e)).sorted().mapToInt(e -> e.value).toArray();
    }
    
    class Int implements Comparable<Int> {
        int value;
        Int(int value) {
            this.value = value;
        }
        @Override
        public int compareTo(Int o) {
            int temp = Math.abs(value - N) - Math.abs(o.value - N);
            return temp == 0 ? value > o.value ? -1 : 1 : temp;
        }
    }
}