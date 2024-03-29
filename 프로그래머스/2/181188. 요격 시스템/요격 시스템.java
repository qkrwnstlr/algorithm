import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int count = 0;
        int temp = -1;
        
        for(int i = 0; i < targets.length; i++) {
            int[] target = targets[i];
            if(target[0] < temp) continue;
            count++;
            temp = target[1];
        }
        
        return count;
    }
}