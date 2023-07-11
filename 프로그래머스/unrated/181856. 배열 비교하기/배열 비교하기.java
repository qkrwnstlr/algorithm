import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) return 1;
        else if(arr1.length < arr2.length) return -1;
        else {
            if(Arrays.stream(arr1).reduce(Integer::sum).getAsInt() > Arrays.stream(arr2).reduce(Integer::sum).getAsInt()) return 1;
            else if(Arrays.stream(arr1).reduce(Integer::sum).getAsInt() < Arrays.stream(arr2).reduce(Integer::sum).getAsInt()) return -1;
            else return 0;
        }
    }
}