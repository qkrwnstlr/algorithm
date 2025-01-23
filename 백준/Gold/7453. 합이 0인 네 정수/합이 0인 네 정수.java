import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  long result;
  int[] A, B, C, D;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    A = new int[N];
    B = new int[N];
    C = new int[N];
    D = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      A[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
      C[i] = Integer.parseInt(st.nextToken());
      D[i] = Integer.parseInt(st.nextToken());
    }
  }

  void solution() {
    int[] AB = new int[N * N], CD = new int[N * N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        AB[i * N + j] = A[i] + B[j];
        CD[i * N + j] = C[i] + D[j];
      }
    }

    Arrays.sort(AB);
    Arrays.sort(CD);

    int i = 0, j = N * N - 1;
    while (i < N * N && j >= 0) {
      int sum = AB[i] + CD[j];
      if (sum < 0) i++;
      else if (sum > 0) j--;
      else {
        int ni = i + 1, nj = j - 1;
        while (ni < N * N && AB[i] == AB[ni]) ni++;
        while (nj >= 0 && CD[j] == CD[nj]) nj--;
        result += (long) (ni - i) * (j - nj);
        i = ni;
        j = nj;
      }
    }
  }
}