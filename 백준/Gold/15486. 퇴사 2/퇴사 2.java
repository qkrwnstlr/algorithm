import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() throws IOException {
    int[] dp = new int[N + 1];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
      if (i + t <= N) dp[i + t] = Math.max(dp[i + t], dp[i] + w);
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
    }

    result = dp[N];
  }
}
