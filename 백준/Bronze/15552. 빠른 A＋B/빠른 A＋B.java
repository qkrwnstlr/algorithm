import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  StringTokenizer st;
  int N, a, b, result;

  void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      init();
      solution();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() {
    result = a + b;
  }
}