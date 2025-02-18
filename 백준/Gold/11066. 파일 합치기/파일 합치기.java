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
  int K;
  int[][] dp, size;
  StringBuilder result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      init();
      solution();
    }
    printResult();

    br.close();
  }

  void init() throws IOException {
    K = Integer.parseInt(br.readLine());

    dp = new int[K][K];

    size = new int[K][K];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) size[i][i] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < K; i++) {
      for (int j = 0; i + j < K; j++) {
        size[j][i + j] = size[j][i + j - 1] + size[j + 1][i + j] - size[j + 1][i + j - 1];
      }
    }
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int i = 1; i < K; i++) {
      for (int j = 0; i + j < K; j++) {
        int k = i + j;
        dp[j][k] = Integer.MAX_VALUE;
        for (int l = j; l < k; l++) {
          dp[j][k] = Integer.min(dp[j][k], dp[j][l] + dp[l + 1][k] + size[j][k]);
        }
      }
    }
    result.append(dp[0][K - 1]).append("\n");
  }
}
