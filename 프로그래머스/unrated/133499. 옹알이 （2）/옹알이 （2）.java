import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling).map(e -> e.replace("ayaaya", "_")).map(e -> e.replace("yeye", "_")).map(e -> e.replace("woowoo", "_")).map(e -> e.replace("mama", "_")).map(e -> e.replace("aya", " ")).map(e -> e.replace("ye", " ")).map(e -> e.replace("woo", " ")).map(e -> e.replace("ma", " ")).map(e -> e.replace(" ", "")).filter(e -> e.equals("")).count();
    }
}