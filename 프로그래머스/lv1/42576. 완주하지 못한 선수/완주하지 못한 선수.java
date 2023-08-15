import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String[] tempP = Arrays.stream(participant).sorted().toArray(String[]::new);
        String[] tempC = Arrays.stream(completion).sorted().toArray(String[]::new);
        for(int i = 0; i < completion.length; i++) if(!tempP[i].equals(tempC[i])) return tempP[i];
        return tempP[tempP.length - 1];
    }
}