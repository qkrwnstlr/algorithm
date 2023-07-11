import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> answer = new ArrayList();
        for(int i = 0; i < strArr.length; i++) answer.add(i % 2 == 1 ? strArr[i].toUpperCase() : strArr[i].toLowerCase());
        return answer.toArray(new String[0]);
    }
}