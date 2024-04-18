import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, K, result, M;
  int[] I, dp;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    result = 0;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    I = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    M = Arrays.stream(I).sorted().skip(N - K).sum() + 2;
    dp = new int[M];
    Arrays.fill(dp, Integer.MAX_VALUE);
  }

  void run() throws IOException {
    init();
    solution();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < M; i++) {
      if (dp[i] == Integer.MAX_VALUE) continue;
      result++;
      sb.append(i).append(" ");
    }
    System.out.println(result);
    System.out.println(sb);
  }

  void solution() {
    for (int i = 0; i < N; i++) {
      for (int j = M - 1; j > 0; j--) {
        if (dp[j] < K) dp[j + I[i]] = Math.min(dp[j] + 1, dp[j + I[i]]);
      }
      dp[I[i]] = 1;
    }
  }
}