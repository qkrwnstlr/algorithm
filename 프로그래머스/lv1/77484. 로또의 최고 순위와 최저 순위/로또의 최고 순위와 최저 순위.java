import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> temp = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int zero = 0;
        int count = 0;
        for(int num : lottos) {
            if(num == 0) zero++;
            else if(temp.contains(num)) count++;
        }
        int max = zero + count > 6 ? 1 : zero + count < 2 ? 6 : 7 - zero - count;
        int min = count < 2 ? 6 : 7 - count;
        return new int[] {max, min};
    }
}