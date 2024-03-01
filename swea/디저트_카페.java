import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
 
    BufferedReader br;
    StringTokenizer st;
    StringBuilder sb;
 
    int N, result;
    int[][] table;
    boolean[] visited;
 
    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase);
 
            N = Integer.parseInt(br.readLine());
            table = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
 
            result = -1;
            visited = new boolean[101];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    DFS(i, j, i, j, 1, 0);
                }
            }
 
            sb.append(" ").append(result).append("\n");
        }
 
        System.out.println(sb);
 
        br.close();
    }
 
    int[] dx = { 1, -1, -1, 1 };
    int[] dy = { 1, 1, -1, -1 };
 
    void DFS(int sx, int sy, int cx, int cy, int count, int flag) {
        if (visited[table[cx][cy]] || flag >= 4) return;
 
        int nx = cx + dx[flag];
        int ny = cy + dy[flag];
 
        if (!isExist(nx, ny)) return;
 
        if (sx == nx && sy == ny) {
            result = Math.max(result, count);
            return;
        }
 
        visited[table[cx][cy]] = true;
        DFS(sx, sy, nx, ny, count + 1, flag);
        DFS(sx, sy, nx, ny, count + 1, flag + 1);
        visited[table[cx][cy]] = false;
    }
 
    boolean isExist(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
