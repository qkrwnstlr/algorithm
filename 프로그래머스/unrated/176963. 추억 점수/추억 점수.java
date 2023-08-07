import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++) map.put(name[i], yearning[i]);
        return Arrays.stream(photo).mapToInt(e -> Arrays.stream(e).filter(map::containsKey).mapToInt(map::get).sum()).toArray();
    }
}