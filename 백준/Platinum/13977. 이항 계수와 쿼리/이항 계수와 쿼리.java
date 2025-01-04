import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K, M, MOD = 1_000_000_007, MAX = 4_000_000;
  long result;
  long[] factorial;

  Main() {
    factorial = new long[MAX + 1];
    factorial[0] = 1;
    for (int i = 1; i <= MAX; i++) {
      factorial[i] = ((factorial[i - 1] % MOD) * i) % MOD;
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      init();
      solution();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
  }

  void solution() {
    result = combination(N, K);
  }

  long combination(int n, int k) {
    if (k > n / 2) k = n - k;
    if (k == 1 || n == k) return n;
    if (k == 0 || n == 1) return 1;
    return factorial[N] * power((factorial[K] * factorial[N - K]) % MOD, MOD - 2) % MOD;
  }

  long power(long a, long n) {
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return a;
    } else if (n % 2 == 0) {
      long c = power(a, n / 2);
      return ((c % MOD) * (c % MOD)) % MOD;
    } else {
      long c = power(a, n - 1);
      return ((c % MOD) * (a % MOD)) % MOD;
    }
  }
}