import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        Map<String, List<String>> temp = Arrays.stream(s.split("")).collect(Collectors.groupingBy(e -> e));
        return temp.keySet().stream().filter(e -> temp.get(e).size() == 1).sorted().collect(Collectors.joining());
    }
}