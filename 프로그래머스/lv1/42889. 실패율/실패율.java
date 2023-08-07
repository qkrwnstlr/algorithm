import java.util.*;
import java.util.stream.*;

class Solution {
    int[] fail;
    int[] success;
    public int[] solution(int N, int[] stages) {
        fail = new int[N];
        success = new int[N];
        for(int stage : stages) {
            if(stage <= N) fail[stage - 1]++;
            for(int i = 0; i < stage - 1; i++) success[i]++;
        }
        return IntStream.rangeClosed(1, N).mapToObj(i -> new Rate(i, (double) fail[i - 1] / success[i - 1])).sorted().mapToInt(e -> e.index).toArray();
    }
    
    class Rate implements Comparable<Rate> {
        int index;
        double rate;
        Rate(int index, double rate) {
            this.index = index;
            this.rate = rate;
        }
        
        @Override
        public int compareTo(Rate o) {
            if(rate > o.rate) return -1;
            else if(rate < o.rate) return 1;
            else return index - o.index;
        }
    }
}