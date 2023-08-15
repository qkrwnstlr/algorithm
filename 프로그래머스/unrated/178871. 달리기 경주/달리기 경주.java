import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            nameMap.put(players[i], i);
            rankMap.put(i, players[i]);
        }
        for(String name : callings) {
            int rank = nameMap.get(name);
            String forward = rankMap.get(rank - 1);
            nameMap.put(name, rank - 1);
            nameMap.put(forward, rank);
            rankMap.put(rank - 1, name);
            rankMap.put(rank, forward);
        }
        return rankMap.values().toArray(String[]::new);
    }
}