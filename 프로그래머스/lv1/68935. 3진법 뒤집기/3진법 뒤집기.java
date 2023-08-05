import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        String[] temp = sb.reverse().toString().split("");
        System.out.println(Arrays.toString(temp));
        return IntStream.range(0, temp.length).map(i -> (int) Math.pow(3, i) * Integer.parseInt(temp[i])).sum();
    }
}