import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        int[] tempX = new int[10];
        int[] tempY = new int[10];
        Arrays.stream(X.split("")).forEach(e -> tempX[Integer.parseInt(e)]++);
        Arrays.stream(Y.split("")).forEach(e -> tempY[Integer.parseInt(e)]++);
        String answer = IntStream.range(0, 10).map(i -> 9 - i).mapToObj(i -> Integer.toString(i).repeat(Math.min(tempX[i], tempY[i]))).collect(Collectors.joining());
        return answer.isEmpty() ? "-1" : answer.charAt(0) == '0' ? "0" : answer;
    }
}