import java.util.*;

class Solution {
    public String solution(String my_string, String alp) {
        return Arrays.stream(my_string.split("")).map(e -> e.equals(alp) ? e.toUpperCase() : e).reduce((x, y) -> x + y).get();
    }
}