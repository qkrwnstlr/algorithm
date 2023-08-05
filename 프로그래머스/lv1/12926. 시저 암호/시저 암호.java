import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s, int n) {
        return IntStream.range(0, s.length()).mapToObj(i -> s.charAt(i) == ' ' ? " " : Character.isLowerCase(s.charAt(i)) ? String.valueOf((char) ('a' + (s.charAt(i) - 'a' + n) % 26)) : String.valueOf((char) ('A' + (s.charAt(i) - 'A' + n) % 26))).collect(Collectors.joining());
    }
}