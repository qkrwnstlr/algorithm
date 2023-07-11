import java.util.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        List<Integer> answer = new ArrayList();
        int even = arr.length % 2 == 0 ? 0 : n;
        int odd = arr.length % 2 == 0 ? n : 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) answer.add(arr[i] + even);
            else answer.add(arr[i] + odd);
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}