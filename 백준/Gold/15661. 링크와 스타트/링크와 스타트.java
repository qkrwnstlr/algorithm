import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result, totalSum;
  int[] rowSum, columnSum;
  int[][] table;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    N = Integer.parseInt(br.readLine());
    table = new int[N][N];
    for (int i = 0; i < N; i++)
      table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    totalSum = 0;
    rowSum = new int[N];
    columnSum = new int[N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        totalSum += table[i][j];
        rowSum[i] += table[i][j];
        columnSum[j] += table[i][j];
      }
    }
    combination(totalSum, 0);
  }

  void combination(int totalSum, int depth) {
    if (depth == N) {
      result = Math.min(result, Math.abs(totalSum));
      return;
    }
    combination(totalSum - rowSum[depth] - columnSum[depth], depth + 1);
    combination(totalSum, depth + 1);
  }
}
