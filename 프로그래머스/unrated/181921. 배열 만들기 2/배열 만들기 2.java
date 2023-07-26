import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = (ArrayList<Integer> )IntStream.rangeClosed(l, r).filter(e -> Integer.toString(e).matches("^[05]*$")).boxed().collect(Collectors.toList());
        if(answer.isEmpty()) answer.add(-1);
        return answer.stream().mapToInt(e -> e).toArray();
    }
}