import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, result;
  boolean[] col, left, right;

  void init() throws IOException {
    result = 0;
    N = Integer.parseInt(br.readLine());
    col = new boolean[N];
    left = new boolean[N * 2 + 1];
    right = new boolean[N * 2 + 1];
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");

    System.out.println(sb);

    br.close();
  }

  void solution() {
    nQueen(0);
  }

  void nQueen(int y) {
    if (y == N) {
      result++;
      return;
    }

    for (int x = 0; x < N; x++) {
      if (col[x] || left[y - x + N] || right[y + x]) continue;
      col[x] = left[y - x + N] = right[y + x] = true;
      nQueen(y + 1);
      col[x] = left[y - x + N] = right[y + x] = false;
    }
  }
}