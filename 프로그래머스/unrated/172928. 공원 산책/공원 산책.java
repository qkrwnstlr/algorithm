import java.util.*;

class Solution {
    int[] current;
    int[][] map;
    public int[] solution(String[] park, String[] routes) {
        map = new int[park.length][park[0].length()];
        current = new int[2];
        for(int i = 0; i < park.length; i++) {
            String[] temp = park[i].split("");
            for(int j = 0; j < temp.length; j++) {
                switch(temp[j]) {
                    case "S": current[0] = i; current[1] = j; break;
                    case "X": map[i][j] = -1; break;
                }
            }
        }
        for(String s : routes) {
            String[] temp = s.split(" ");
            String direction = temp[0];
            int distance = Integer.parseInt(temp[1]);
            switch(direction) {
                case "E": if(current[1] + distance < map[0].length && isAble(new int[]{current[0], current[1] + distance})) current[1] += distance; break;
                case "W": if(current[1] - distance >= 0 && isAble(new int[]{current[0], current[1] - distance})) current[1] -= distance; break;
                case "S": if(current[0] + distance < map.length && isAble(new int[]{current[0] + distance, current[1]})) current[0] += distance; break;
                case "N": if(current[0] - distance >= 0 && isAble(new int[]{current[0] - distance, current[1]})) current[0] -= distance; break;
            }
        }
        return current;
    }
    
    boolean isAble(int[] to) {
        int maxX = Math.max(current[0], to[0]);
        int minX = Math.min(current[0], to[0]);
        int maxY = Math.max(current[1], to[1]);
        int minY = Math.min(current[1], to[1]);
        for(int i = minX; i <= maxX; i++) if(map[i][current[1]] == -1) return false;
        for(int i = minY; i <= maxY; i++) if(map[current[0]][i] == -1) return false;
        return true;
    }
}