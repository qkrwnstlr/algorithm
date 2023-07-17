import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch(n) {
            case 1: return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
            case 2: return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3: return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
            case 4:
                int[] temp = Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
                return IntStream.range(0, temp.length).filter(i -> i % slicer[2] == 0).map(i -> temp[i]).toArray();
            default: return new int[0];
        }
    }
}