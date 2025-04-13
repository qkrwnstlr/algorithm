import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int D, P, Q, result;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    D = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    if (D % P == 0 || D % Q == 0) {
      result = D;
      return;
    }

    if (P < Q) {
      int temp = P;
      P = Q;
      Q = temp;
    }

    int min = P;
    for (int i = 0; i <= Math.min(D / P, Q); i++) {
      min = Math.min(min, (Q - (D - P * i) % Q) % Q);
    }
    min = Math.min(min, (P - (D % P)) % P);
    result = D + min;
  }
}
