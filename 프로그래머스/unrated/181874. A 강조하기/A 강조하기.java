import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return Arrays.stream(myString.toLowerCase().split("")).map(e -> e.equals("a") ? "A" : e).collect(Collectors.joining());
    }
}