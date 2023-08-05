import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        String[] map1 = Arrays.stream(arr1).mapToObj(e -> String.format("%" + n + "s", Integer.toBinaryString(e)).replace(" ", "0")).toArray(String[]::new);
        String[] map2 = Arrays.stream(arr2).mapToObj(e -> String.format("%" + n + "s", Integer.toBinaryString(e)).replace(" ", "0")).toArray(String[]::new);
        return IntStream.range(0, n).mapToObj(i -> IntStream.range(0, n).mapToObj(j -> map1[i].charAt(j) == '1' || map2[i].charAt(j)  == '1' ? "#" : " ").collect(Collectors.joining())).toArray(String[]::new);
    }
}