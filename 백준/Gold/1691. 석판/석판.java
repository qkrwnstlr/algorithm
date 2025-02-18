import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int W, H, N, result;
  int[][] dp;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(br.readLine());

    dp = new int[W + 1][H + 1];
    for (int i = 1; i <= W; i++) {
      for (int j = 1; j <= H; j++) {
        dp[i][j] = i * j;
      }
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0;
    }
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int w = 1; w <= W; w++) {
      for (int h = 1; h <= H; h++) {
        for (int cutW = 1; cutW <= w / 2; cutW++) dp[w][h] = Math.min(dp[w][h], dp[w - cutW][h] + dp[cutW][h]);
        for (int cutH = 1; cutH <= h / 2; cutH++) dp[w][h] = Math.min(dp[w][h], dp[w][h - cutH] + dp[w][cutH]);
      }
    }
    result = dp[W][H];
  }
}
