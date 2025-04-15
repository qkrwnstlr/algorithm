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

    int answer = Integer.MAX_VALUE;

    // P를 i번 사용해서 만든 금액 = P * i
    for (int i = 0; i <= Math.min(D / P + 1, Q); i++) {
      int pTotal = P * i;
      int remain = D - pTotal;

      // Q로 나눠떨어지지 않으면 Q로 나눠떨어지는 가장 가까운 큰 수로 올려줌
      int qTotal = 0;
      if (remain > 0) {
        qTotal = (remain + Q - 1) / Q * Q;
      }

      int total = pTotal + qTotal;
      if (total >= D) {
        answer = Math.min(answer, total);
      }
    }

    result = answer;
  }
}
