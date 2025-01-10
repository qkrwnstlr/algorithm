import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K, result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");
    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
  }

  void solution() {
    while (Integer.bitCount(N) > K) {
      result += N & (-N);
      N += N & (-N);
    }
  }
}