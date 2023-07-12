import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int before = numLog[0];
        for(int i = 1; i< numLog.length; i++) {
            switch(numLog[i] - before) {
                case 1:
                    sb.append("w");
                    break;
                case -1:                    
                    sb.append("s");
                    break;
                case 10:
                    sb.append("d");
                    break;
                case -10:
                    sb.append("a");
                    break;
            }
            before = numLog[i];
        }
        return sb.toString();
    }
}