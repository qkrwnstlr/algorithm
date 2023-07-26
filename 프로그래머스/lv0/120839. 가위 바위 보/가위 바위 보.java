import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String rsp) {
        return Arrays.stream(rsp.split("")).map(e -> e.equals("0") ? "5" : e.equals("2") ? "0" : "2").collect(Collectors.joining());
    }
}