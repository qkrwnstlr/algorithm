import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int height) {
        ArrayList<Integer> answer = (ArrayList<Integer>)Arrays.stream(array).boxed().collect(Collectors.toList());
        answer.add(height);
        return answer.stream().sorted((a, b) -> b - a).collect(Collectors.toList()).indexOf(height);
    }
}