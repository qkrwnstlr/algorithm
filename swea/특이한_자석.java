import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws IOException {
    new Solution().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, K, result;
  int[][] magnets;
  int[] top;
  int[][] rotations;

  void init() throws IOException {
    result = 0;
    N = 4;
    K = Integer.parseInt(br.readLine());
    magnets = new int[N + 1][8];
    top = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      magnets[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    rotations = new int[K][2];
    for (int i = 0; i < K; i++) {
      rotations[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      init();
      solution();
      sb.append("#").append(testCase).append(" ").append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() {
    for (int i = 0; i < K; i++) rotate(rotations[i][0], rotations[i][1]);
    for (int i = 1; i <= N; i++) result += magnets[i][top[i]] << (i - 1);
  }

  void rotate(int target, int direction) {
    int[] distances = new int[N + 1];
    distances[target] = -direction;

    for (int current = target; current > 1 && magnets[current][movedIndex(current, -2)] != magnets[current - 1][movedIndex(current - 1, 2)]; current--) {
      distances[current - 1] = -distances[current];
    }

    for (int current = target; current < N && magnets[current][movedIndex(current, 2)] != magnets[current + 1][movedIndex(current + 1, -2)]; current++) {
      distances[current + 1] = -distances[current];
    }

    for (int i = 1; i <= N; i++) top[i] = movedIndex(i, distances[i]);
  }

  int movedIndex(int target, int distance) {
    return (8 + top[target] + distance) % 8;
  }
}
