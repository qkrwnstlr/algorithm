import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s, String skip, int index) {
        List<String> temp = Arrays.stream(skip.split("")).collect(Collectors.toList());
        List<String> alphabet = Arrays.stream(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}).filter(e -> !temp.contains(e)).collect(Collectors.toList());
        return Arrays.stream(s.split("")).map(e -> alphabet.get((alphabet.indexOf(e) + index) % alphabet.size())).collect(Collectors.joining());
    }
}