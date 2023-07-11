import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        return myString.replace("A", "C").replace("B", "A").replace("C", "B").contains(pat) ? 1 : 0;
    }
}