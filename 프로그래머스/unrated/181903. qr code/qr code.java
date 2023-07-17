import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0, code.length()).filter(i -> i % q == r).mapToObj(i -> code.split("")[i]).collect(Collectors.joining());
    }
}