import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K;
  long result;
  int[] arr;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
  }

  void solution() {
    Arrays.sort(arr);
    int max = Math.min(50001, Arrays.stream(arr).sum() + 1) + 1;
    int[][][] dp = new int[N + 1][K + 1][max];

    for (int i = 1; i <= N; i++) {
      dp[i][1][arr[i]] = 1;
      for (int j = 1; j <= Math.min(i + 1, K); j++) {
        for (int k = 0; k < max; k++) {
          dp[i][j][k] += dp[i - 1][j][k];
          dp[i][j][Math.min(k + arr[i], max - 1)] += dp[i - 1][j - 1][k];
        }
      }
    }

    for (int i = K; i <= N; i++) {
      for (int k = arr[i] + 1; k < max; k++) {
        result += dp[i - 1][K - 1][k];
      }
    }
  }
}
