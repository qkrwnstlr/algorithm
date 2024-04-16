import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int T, W, N, result;
  int[][] counts, dp;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    result = 0;
    T = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    List<Integer> temp1 = new ArrayList<>(), temp2 = new ArrayList<>();
    int before = Integer.parseInt(br.readLine()), count = 1;
    for (int i = 1; i < T; i++) {
      int current = Integer.parseInt(br.readLine());
      if (before == current) {
        count++;
        continue;
      }

      if (before == 1) {
        temp1.add(count);
        temp2.add(0);
      } else {
        temp1.add(0);
        temp2.add(count);
      }
      before = current;
      count = 1;
    }

    if (before == 1) {
      temp1.add(count);
      temp2.add(0);
    } else {
      temp1.add(0);
      temp2.add(count);
    }

    counts = new int[2][];
    counts[0] = temp1.stream().mapToInt(Integer::intValue).toArray();
    counts[1] = temp2.stream().mapToInt(Integer::intValue).toArray();

    N = counts[0].length;
    dp = new int[W + 1][N + 1];
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    for (int i = 1; i < N + 1; i++) {
      dp[0][i] = dp[0][i - 1] + counts[0][i - 1];
      for (int j = 1; j < W + 1; j++) {
        dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 1]) + counts[j % 2][i - 1];
      }
    }
    for (int i = 0; i < W + 1; i++) result = Math.max(result, dp[i][N]);
  }
}