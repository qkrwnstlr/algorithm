import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  long[][] dp;
  StringBuilder result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() {
    result = new StringBuilder();
    dp = new long[31][31];
    for (int i = 0; i <= 30; i++) dp[0][i] = 1;

    for (int i = 1; i <= 30; i++) {
      for (int j = 1; j <= 30; j++) {
        if (i > j) continue;
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() throws IOException {
    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) return;
      result.append(dp[N][N]).append("\n");
    }
  }
}