import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M, result;

  int[][] dp;

  void init() throws IOException {
    result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    dp = new int[N + 1][N + 1];
    for (int y = 1; y <= N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 1; x <= N; x++) {
        dp[y][x] = dp[y][x - 1] + dp[y - 1][x] - dp[y - 1][x - 1] + Integer.parseInt(st.nextToken());
      }
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    for (int i = 0; i < M; i++) {
      solution();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int y1 = Integer.parseInt(st.nextToken());
    int x1 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    int x2 = Integer.parseInt(st.nextToken());
    result = dp[y2][x2] + dp[y1 - 1][x1 - 1] - dp[y2][x1 - 1] - dp[y1 - 1][x2];
  }
}