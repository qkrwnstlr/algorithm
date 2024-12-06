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

  void init() throws IOException {
    result = 0;
    N = Integer.parseInt(br.readLine());
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
    nQueen(0, 0, 0, 0);
  }

  void nQueen(int y, int col, int left, int right) {
    if (y == N) {
      result++;
      return;
    }

    for (int x = 0; x < N; x++) {
      if (isBitOn(col, x) || isBitOn(left, y - x + N) || isBitOn(right, y + x)) continue;
      nQueen(y + 1, setBitOn(col, x), setBitOn(left, y - x + N), setBitOn(right, y + x));
    }
  }

  boolean isBitOn(int bit, int index) {
    return (bit & (1 << index)) > 0;
  }

  int setBitOn(int bit, int index) {
    return bit | (1 << index);
  }
}