import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = n; i < num_list.length; i++) answer.add(num_list[i]);
        for(int i = 0; i < n; i++) answer.add(num_list[i]);
        return answer.stream().mapToInt(x -> x).toArray();
    }
}