import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  int N, M, result;
  int[] m, c;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
  }

  void solution() {
    // 이 비용일때 최대로 뽑을 수 있는..?
    App[] apps = new App[N];
    int max = Arrays.stream(c).sum();
    int[] dp = new int[max + 1];
    for (int i = 0; i < N; i++) apps[i] = new App(m[i], c[i]);
    Arrays.sort(apps, (o1, o2) -> o1.c - o2.c);
    for (int i = 0; i < N; i++) {
      for (int j = max; j >= apps[i].c; j--) {
        dp[j] = Math.max(dp[j], dp[j - apps[i].c] + apps[i].m);
      }
    }
    for (int i = 0; i <= max; i++) {
      if (dp[i] >= M) {
        result = i;
        break;
      }
    }
  }

  void result() {
    System.out.println(result);
  }

  void run() throws IOException {
    init();
    solution();
    result();
  }

  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}

class App {
  int m, c;

  App(int m, int c) {
    this.m = m;
    this.c = c;
  }
}