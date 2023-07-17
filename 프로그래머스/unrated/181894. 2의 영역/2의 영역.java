import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] twos = IntStream.range(0, arr.length).filter(e -> arr[e] == 2).toArray();
        if(twos.length == 0) return new int[]{-1};
        else return Arrays.copyOfRange(arr, twos[0], twos[twos.length - 1] + 1);
    }
}