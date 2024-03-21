import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, K, result;
  int[] coins, dp;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    result = 0;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    coins = new int[N];
    for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
    dp = new int[K + 1];
    dp[0] = 1;
    br.close();
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    for (int i = 0; i < N; i++) {
      for (int j = coins[i]; j <= K; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }
    result = dp[K];
  }
}
