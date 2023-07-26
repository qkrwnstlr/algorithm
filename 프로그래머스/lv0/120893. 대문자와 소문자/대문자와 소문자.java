import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split("")).map(e -> e.equals(e.toUpperCase()) ? e.toLowerCase() : e.toUpperCase()).collect(Collectors.joining());
    }
}