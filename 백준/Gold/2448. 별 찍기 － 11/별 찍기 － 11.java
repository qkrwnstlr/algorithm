import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N;
  char[][] result;

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    result = new char[N + 1][N * 2 + 10];
    for (int i = 0; i < N + 1; i++) Arrays.fill(result[i], ' ');
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    for (int x = 1; x <= N; x++) {
      for (int y = 1; y <= N * 2; y++) {
        sb.append(result[x][y]);
      }
      sb.append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() {
    draw(1, N, N);
  }

  void draw(int x, int y, int n) {
    if (n == 3) {
      result[x][y] = '*';
      result[x + 1][y - 1] = '*';
      result[x + 1][y + 1] = '*';
      result[x + 2][y - 2] = '*';
      result[x + 2][y - 1] = '*';
      result[x + 2][y] = '*';
      result[x + 2][y + 1] = '*';
      result[x + 2][y + 2] = '*';
      return;
    }

    int n2 = n / 2;
    draw(x, y, n2);
    draw(x + n2, y - n2, n2);
    draw(x + n2, y + n2, n2);
  }
}