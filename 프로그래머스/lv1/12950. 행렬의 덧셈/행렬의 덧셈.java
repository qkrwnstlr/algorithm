import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        return IntStream.range(0, arr1.length).mapToObj(e -> IntStream.range(0, arr1[e].length).map(i -> arr1[e][i] + arr2[e][i]).toArray()).toArray(int[][]::new);
    }
}