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
  int[] result;
  int[][] paper;

  void init() throws IOException {
    result = new int[3];
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for (int x = 0; x < N; x++)
      paper[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    for (int i = 0; i < 3; i++) sb.append(result[i]).append("\n");

    System.out.println(sb);

    br.close();
  }

  void solution() {
    draw(0, 0, N);
  }

  void draw(int sx, int sy, int n) {
    for (int x = sx; x < sx + n; x++) {
      for (int y = sy; y < sy + n; y++) {
        if (paper[x][y] == paper[sx][sy]) continue;
        int n3 = n / 3;
        for (int dx = 0; dx < 3; dx++) {
          for (int dy = 0; dy < 3; dy++) {
            draw(sx + n3 * dx, sy + n3 * dy, n3);
          }
        }
        return;
      }
    }
    result[paper[sx][sy] + 1]++;
  }
}