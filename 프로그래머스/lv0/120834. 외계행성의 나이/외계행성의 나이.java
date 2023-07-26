import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int age) {
        return Integer.toString(age).chars().mapToObj(e -> Character.toString('a' + e - '0')).collect(Collectors.joining());
    }
}