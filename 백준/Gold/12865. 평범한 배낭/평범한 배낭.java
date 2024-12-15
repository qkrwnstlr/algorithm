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
  StringBuilder result;
  int N, K;
  int[][] object;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    object = new int[N][2];
    for (int i = 0; i < N; i++)
      object[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void solution() {
    int[] dp = new int[K + 1];
    for (int i = 0; i < N; i++) {
      for (int j = K; j >= object[i][0]; j--) {
        dp[j] = Math.max(dp[j], dp[j - object[i][0]] + object[i][1]);
      }
    }
    result.append(dp[K]);
  }
}