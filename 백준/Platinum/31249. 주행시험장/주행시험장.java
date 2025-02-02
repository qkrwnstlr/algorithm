import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M;
  long k, count;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      init();
      solution();
      sb.append(k).append(" ").append(count).append("\n");
    }
    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
  }

  void solution() {
    int max = Math.max(N, M), min = Math.min(N, M);
    if (min == max) {
      k = min;
      count = 3;
    } else if (max > 2 * min) {
      k = min + 1;
      if (max > 2 * k) {
        count = 7 + (max - 2 * k) * 2;
      } else if (max == 3 && min == 1) {
        count = 5;
      } else {
        count = 7;
      }
    } else {
      k = min;
      count = 7;
    }
  }
}
