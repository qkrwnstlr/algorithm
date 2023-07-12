import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length == 1 ? 1 : (int) Math.pow(2, Integer.toBinaryString(arr.length - 1).length());
        int[] answer = new int[length];
        for(int i = 0; i < arr.length; i++) answer[i] = arr[i];
        return answer;
    }
}