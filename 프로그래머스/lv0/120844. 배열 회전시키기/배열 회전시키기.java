import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        ArrayList<Integer> answer = (ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());
        if(direction.equals("left")) {
        int temp = answer.remove(0);
        answer.add(temp);
        } else {
            int temp = answer.remove(answer.size() - 1);
            answer.addAll(0, Collections.singleton(temp));
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
}