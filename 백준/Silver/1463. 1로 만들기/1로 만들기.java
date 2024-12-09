import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, result;

  int[] dp;

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    for (int i = 2; i <= Math.min(N, 3); i++) dp[i] = 1;
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");

    System.out.println(sb);

    br.close();
  }

  void solution() {
    for (int i = 4; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }
    result = dp[N];
  }
}