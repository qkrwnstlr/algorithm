import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String cipher, int code) {
        String[] temp = cipher.split("");
        return IntStream.range(0, cipher.length()).filter(i -> i % code == code - 1).mapToObj(i -> temp[i]).collect(Collectors.joining());
    }
}