import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
        Map<Point, boolean[]> visited = new HashMap<>();

        Point current = new Point(0, 0);
        boolean[] currentV = new boolean[8];
        visited.put(current, currentV);
        
        for (int arrow: arrows) {
            for(int i = 0; i < 2; i++) {
                Point next = new Point(current.r + dr[arrow], current.c + dc[arrow]);
                boolean[] nextV = visited.get(next);

                if(nextV != null && !nextV[(arrow + 4) % 8]) answer++;
                if(nextV == null) nextV = new boolean[8];

                currentV[arrow] = true;
                nextV[(arrow + 4) % 8] = true;

                visited.put(next, nextV);

                current = next;
                currentV = nextV;
            }
        }
        
        return answer;
    }
}

class Point {
    public int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return r == p.r && c == p.c;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}