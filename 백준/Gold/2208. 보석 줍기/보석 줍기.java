import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M, result;
  int[] arr;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
  }

  void solution() {
    int[] dp = new int[N], sum = new int[N];
    sum[0] = arr[0];
    for (int i = 1; i < N; i++) sum[i] = sum[i - 1] + arr[i];
    dp[M - 1] = sum[M - 1];
    for (int i = M; i < N; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], sum[i] - sum[i - M]);
      result = Math.max(result, dp[i]);
    }
  }
}