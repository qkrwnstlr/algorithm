import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        List<String> splited = new ArrayList(Arrays.asList(my_string.split("")));
        Arrays.sort(indices);
        for(int i = 0; i < indices.length; i++) splited.remove(indices[i] - i);
        return splited.stream().reduce((x, y) -> x + y).get();
    }
}