import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, L, R, MOD = 1000000007;
  long result;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());


    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    long[][][] dp = new long[N + 1][N + 1][N + 1];

    dp[1][1][1] = 1;

    for (int i = 2; i <= N; i++) {
      for (int j = 1; j <= L; j++) {
        for (int k = 1; k <= R; k++) {
          dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k] + dp[i - 1][j][k] * (i - 2)) % MOD;
        }
      }
    }

    result = dp[N][L][R];
  }
}