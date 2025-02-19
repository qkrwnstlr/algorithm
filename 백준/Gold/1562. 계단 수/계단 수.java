import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result, MOD = 1_000_000_000;
  int[][][] dp;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1][10][1 << 10];
    for (int i = 1; i < 10; i++) dp[1][i][1 << i] = 1;
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k < (1 << 10); k++) {
          if (j != 0) dp[i][j][k | 1 << j] += dp[i - 1][j - 1][k];
          if (j != 9) dp[i][j][k | 1 << j] += dp[i - 1][j + 1][k];
          dp[i][j][k | 1 << j] %= MOD;
        }
      }
    }

    for (int i = 0; i < 10; i++) result = (result + dp[N][i][(1 << 10) - 1]) % MOD;
  }
}
