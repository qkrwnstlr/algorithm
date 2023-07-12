import java.util.*;

class Solution {
    public int solution(String number) {
        return Arrays.stream(number.split("")).map(e -> Integer.parseInt(e)).reduce(Integer::sum).get() % 9;
    }
}