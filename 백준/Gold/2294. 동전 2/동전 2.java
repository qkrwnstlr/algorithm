import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K, result;
  int[] coins;
  int[] dp;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dp = new int[K + 1];
    for (int i = 1; i <= K; i++) dp[i] = 10001;
    coins = new int[N];
    for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int i = 0; i < N; i++) {
      for (int j = coins[i]; j <= K; j++) {
        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
      }
    }
    result = dp[K] == 10001 ? -1 : dp[K];
  }
}