import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;
  int[][] arr, dp;

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    dp = new int[N][1 << N];
    for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void printResult() {
    StringBuilder sb = new StringBuilder();

    sb.append(result).append("\n");

    sb.append(1).append(" ");
    trace(0, 1, sb);

    System.out.println(sb);
  }

  void solution() {
    result = dfs(0, 1) + 1;
  }

  int dfs(int node, int visited) {
    if (dp[node][visited] != -1) return dp[node][visited];

    int result = 0;

    for (int i = 0; i < N; i++) {
      if (arr[node][i] == 0 || (visited & (1 << i)) != 0) continue;
      result = Math.max(result, dfs(i, visited | (1 << i)) + 1);
    }

    return dp[node][visited] = result;
  }

  void trace(int node, int visited, StringBuilder sb) {
    for (int i = 0; i < N; i++) {
      if (arr[node][i] == 0 || (visited & (1 << i)) != 0) continue;
      if (dp[node][visited] == dp[i][visited | (1 << i)] + 1) {
        sb.append(i + 1).append(" ");
        trace(i, visited | (1 << i), sb);
        break;
      }
    }
  }
}
