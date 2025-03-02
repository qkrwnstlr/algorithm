import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int result, INF = 1000;
  String O, N;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    O = br.readLine();
    N = br.readLine();

    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    if (O.length() > N.length()) {
      result = -1;
      return;
    }

    if (O.equals(N)) {
      result = 0;
      return;
    }

    int[][][] dp = new int[O.length() + 1][N.length() + 1][2];

    dp[0][0][0] = 0;
    dp[0][0][1] = INF;

    for (int i = 1; i <= N.length(); i++) {
      dp[0][i][0] = INF;
      dp[0][i][1] = 1;
    }

    for (int i = 0; i < O.length(); i++) {
      for (int j = 0; j <= i; j++) {
        dp[i + 1][j][0] = dp[i + 1][j][1] = INF;
      }

      for (int j = i; j < N.length(); j++) {
        if (O.charAt(i) == N.charAt(j)) {
          dp[i + 1][j + 1][0] = Math.min(dp[i][j][0], dp[i][j][1]);
        } else {
          dp[i + 1][j + 1][0] = INF;
        }
        dp[i + 1][j + 1][1] = Math.min(dp[i + 1][j][0] + 1, dp[i + 1][j][1]);
      }
    }

    result = Math.min(dp[O.length()][N.length()][0], dp[O.length()][N.length()][1]);
    if (result == INF) result = -1;
  }
}