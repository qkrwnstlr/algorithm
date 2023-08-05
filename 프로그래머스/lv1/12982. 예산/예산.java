import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int[] temp = Arrays.stream(d).sorted().toArray();
        int total = 0;
        for(int i = 0; i < temp.length; i++) {
            total += temp[i];
            if(total > budget) return i;
        }
        return temp.length;
    }
}