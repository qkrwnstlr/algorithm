import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(4, n).filter(e -> {
            int count = 0;
            for(int i = 1; i * i <= e; i++) {
                if(i * i == e) count++;
                else if(e % i == 0) count += 2;
                if(count > 2) return true;
            }
            return false;
        }).count();
    }
}