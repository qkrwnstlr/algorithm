import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  ArrayDeque<Integer> result;
  int[][] lines;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result.size());
    result.forEach(System.out::println);

    br.close();
  }

  void init() throws IOException {
    result = new ArrayDeque<>();
    N = Integer.parseInt(br.readLine());
    lines = new int[N][2];
    for (int i = 0; i < N; i++)
      lines[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    Arrays.sort(lines, Comparator.comparing(it -> it[0]));
    int[] dp = new int[N];
    int[] x = new int[N];
    int lis = 1;

    for (int i = 0; i < N; i++) {
      int index = Arrays.binarySearch(x, 0, lis, lines[i][1]);
      index = index >= 0 ? index : Math.abs(index) - 1;
      x[index] = lines[i][1];
      dp[i] = index + 1;
      lis = Math.max(lis, dp[i]);
    }

    for (int i = N - 1; i >= 0; i--) {
      if (dp[i] != lis) result.addFirst(lines[i][0]);
      else lis--;
    }
  }
}
