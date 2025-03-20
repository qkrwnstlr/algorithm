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
  StringTokenizer st;
  int N, result;
  long X;
  long[] C;

  void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Long.parseLong(st.nextToken());
    C = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
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
    Arrays.sort(C);
    int left = 0, right = N - 1;
    for (; right >= 0 && C[right] >= X; right--) result++;
    int count = 0;
    while (left < right) {
      if ((C[left] + C[right]) * 2L < X) {
        left++;
      } else {
        count++;
        left++;
        right--;
      }
    }
    result += (N - result - count * 2) / 3;
    result += count;
  }
}
