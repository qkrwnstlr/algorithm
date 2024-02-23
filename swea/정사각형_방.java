import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
 
    BufferedReader br;
    StringTokenizer st;
    StringBuilder sb;
 
    int N;
    Room[][] graph;
    Room result;
 
    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase);
 
            N = Integer.parseInt(br.readLine());
 
            graph = new Room[N][N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = new Room(i, j, Integer.parseInt(st.nextToken()));
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (isExist(nx, ny)) {
                            graph[i][j].addNext(graph[nx][ny]);
                        }
                    }
                }
            }
 
            result = graph[0][0];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (result.count < graph[i][j].count) {
                        result = graph[i][j];
                    } else if (result.count == graph[i][j].count && result.value > graph[i][j].value) {
                        result = graph[i][j];
                    }
                }
            }
 
            sb.append(" ").append(result.value).append(" ").append(result.count).append("\n");
        }
 
        System.out.println(sb);
 
        br.close();
    }
 
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };
 
    boolean isExist(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
 
class Room {
    int x, y, value, count;
    List<Room> next;
 
    Room(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.count = 1;
        this.next = new ArrayList<>();
    }
 
    void setCount(int count) {
        if (this.count < count) {
            this.count = count;
            for (int i = 0; i < next.size(); i++) {
                next.get(i).setCount(count + 1);
            }
        }
    }
 
    void addNext(Room room) {
        if (this.value == room.value + 1) {
            this.next.add(room);
            room.setCount(this.count + 1);
        }
    }
}
