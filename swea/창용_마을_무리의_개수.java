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
 
    int N, M, result;
    boolean[][] table;
    boolean visited[];
 
    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase);
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            table = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                table[a][b] = true;
                table[b][a] = true;
            }
 
            result = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    BFS(i);
                    result++;
                }
            }
 
            sb.append(" ").append(result).append("\n");
        }
 
        System.out.println(sb);
 
        br.close();
    }
 
    void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
 
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && table[current][i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
