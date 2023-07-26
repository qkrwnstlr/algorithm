import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        String[] temp = code.split("");
        int mode = 0;
        for(int i = 0; i < code.length(); i++) {
            if(mode == 0) {
                if(temp[i].equals("1")) mode = 1;
                else if(i % 2 == 0) sb.append(temp[i]);
            } else {
                if(temp[i].equals("1")) mode = 0;
                else if(i % 2 == 1) sb.append(temp[i]);
            }
        }
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}