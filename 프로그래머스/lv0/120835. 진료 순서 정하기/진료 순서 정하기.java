import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] emergency) {
        ArrayList<Integer> sorted = (ArrayList<Integer>) Arrays.stream(emergency).boxed().sorted((a, b) -> b - a).collect(Collectors.toList());
        ArrayList<Integer> temp = (ArrayList<Integer>) Arrays.stream(emergency).boxed().collect(Collectors.toList());
        return temp.stream().mapToInt(e -> sorted.indexOf(e) + 1).toArray();
    }
}