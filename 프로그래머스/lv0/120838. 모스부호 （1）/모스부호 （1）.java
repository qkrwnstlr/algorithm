import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String letter) {
        ArrayList<String> morse = new ArrayList(List.of(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."));
        return Arrays.stream(letter.split(" ")).map(e -> String.valueOf((char) (morse.indexOf(e) + 'a'))).collect(Collectors.joining());
    }
}