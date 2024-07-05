import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  int N, M;
  boolean[][] graph;
  int[] count;
  StringBuilder result;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    graph = new boolean[N + 1][N + 1];
    count = new int[N + 1];
    for (int i = 1; i <= N; i++) graph[i][i] = true;
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
    }
    result = new StringBuilder();
  }

  void solution() {
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        if (!graph[i][k]) continue;
        for (int j = 1; j <= N; j++) {
          if (graph[i][j] || !graph[k][j]) continue;
          graph[i][j] = true;
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (!graph[i][j] && !graph[j][i]) count[i]++;
      }
    }

    for (int i = 1; i <= N; i++) {
      result.append(count[i]).append("\n");
    }
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}