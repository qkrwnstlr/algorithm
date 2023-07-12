import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        String[] splitString = my_string.split("");
        IntStream.range(0, my_string.length()).forEach(e -> {if(e % m == c - 1) sb.append(splitString[e]);});
        return sb.toString();
    }
}