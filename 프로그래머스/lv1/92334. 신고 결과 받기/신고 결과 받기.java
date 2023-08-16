import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> answer = new HashMap<>();
        for(String id : id_list) map.put(id, new HashSet<>());
        for(String id : id_list) answer.put(id, 0);
        for(String r : report) {
            String[] temp = r.split(" ");
            map.get(temp[1]).add(temp[0]);
        }
        for(String id : map.keySet()) {
            Set<String> temp = map.get(id);
            if(temp.size() >= k) for(String s : temp) answer.put(s, answer.get(s) + 1);
        }
        return Arrays.stream(id_list).mapToInt(id -> answer.get(id)).toArray();
    }
}