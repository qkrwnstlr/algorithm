import java.util.*;
import java.util.stream.*;

class Solution {
    int left = 9;
    int right = 11;
    StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers, String hand) {
        List<Integer> keymap = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,-1,0,-2}).boxed().collect(Collectors.toList());
        for(int n : numbers) moveHand(keymap.indexOf(n), hand);
        return sb.toString();
    }
    
    void moveHand(int to, String hand) {
        if(to % 3 == 0) moveLeft(to);
        else if(to % 3 == 2) moveRight(to);
        else if(isLeftClose(to, hand)) moveLeft(to);
        else moveRight(to);
    }
    
    void moveLeft(int to) {
        left = to;
        sb.append("L");
    }
    
    void moveRight(int to) {
        right = to;
        sb.append("R");
    }
    
    boolean isLeftClose(int to, String hand) {
        int distanceL = getDistance(left, to);
        int distanceR = getDistance(right, to);
        return distanceL == distanceR ? hand.equals("left") : distanceL < distanceR;
    }
    
    int getDistance(int from, int to) {
        return Math.abs(from / 3 - to / 3) + Math.abs(from % 3 - to % 3);
    }
}