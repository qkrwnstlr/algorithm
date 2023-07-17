import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] current = arr;
        while(true) {
            int[] temp = Arrays.stream(current).map(e -> {
                if(e >= 50 && e % 2 == 0) return e / 2;
                else if(e < 50 && e % 2 == 1) return e * 2 + 1;
                else return e;
            }).toArray();
            if(Arrays.equals(current, temp)) return answer;
            answer++;
            current = temp;
        }
    }
}