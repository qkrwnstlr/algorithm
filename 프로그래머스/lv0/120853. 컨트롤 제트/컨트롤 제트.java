import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.stream(s.split(" ")).forEach(e -> {
            if(e.equals("Z")) temp.remove(temp.size() - 1);
            else temp.add(Integer.parseInt(e));
        });
        return temp.stream().reduce(0, Integer::sum);
    }
}