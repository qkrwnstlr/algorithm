import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] temp = new int[n];
        Arrays.stream(lost).forEach(e -> temp[e - 1]--);
        Arrays.stream(reserve).forEach(e -> temp[e - 1]++);
        for(int i = 0; i < n; i++) {
            if(temp[i] <= 0) continue;
            if(i > 0 && temp[i - 1] < 0) temp[i - 1]++;                
            else if(i < n - 1 && temp[i + 1] < 0) temp[i + 1]++;
        }
        return (int) Arrays.stream(temp).filter(e -> e >= 0).count();
    }
}