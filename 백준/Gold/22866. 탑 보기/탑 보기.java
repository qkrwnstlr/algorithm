import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, result;
  int[] buildings, lCount, rCount, lIndex, rIndex;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    result = 0;
    N = Integer.parseInt(br.readLine());
    buildings = new int[N + 2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) buildings[i] = Integer.parseInt(st.nextToken());
    lCount = new int[N + 2];
    rCount = new int[N + 2];
    lIndex = new int[N + 2];
    rIndex = new int[N + 2];
  }

  void run() throws IOException {
    init();
    solution();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      int count = lCount[i] + rCount[i];
      sb.append(count);
      if (count != 0) {
        sb.append(" ");
        if (lIndex[i] == 0) sb.append(rIndex[i]);
        else if (rIndex[i] == N + 1) sb.append(lIndex[i]);
        else sb.append(Math.abs(lIndex[i] - i) <= Math.abs(rIndex[i] - i) ? lIndex[i] : rIndex[i]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  void solution() {
    lIndex[0] = 0;
    for (int i = 1; i <= N; i++) {
      int x = i - 1;
      while (x != 0 && buildings[x] <= buildings[i]) x = lIndex[x];
      lIndex[i] = x;
      if (x == 0) {
        lCount[i] = 0;
      } else {
        lCount[i] = lCount[x] + 1;
      }
    }

    rIndex[N + 1] = N + 1;
    for (int i = N; i >= 1; i--) {
      int x = i + 1;
      while (x != N + 1 && buildings[x] <= buildings[i]) x = rIndex[x];
      rIndex[i] = x;
      if (x == N + 1) {
        rCount[i] = 0;
      } else {
        rCount[i] = rCount[x] + 1;
      }
    }
  }
}