import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M, result;

  int[] dp;

  void init() throws IOException {
    result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    dp = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    for (int i = 0; i < M; i++) {
      solution();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int first = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());
    result = dp[second] - dp[first - 1];
  }
}