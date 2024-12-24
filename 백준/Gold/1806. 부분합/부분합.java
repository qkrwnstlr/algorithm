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
  StringBuilder result;
  int N, S;
  int[] arr;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    int l = 0, r = 0, sum = 0, length = Integer.MAX_VALUE;
    while (r <= N) {
      if (sum >= S) {
        length = Math.min(length, r - l);
        sum -= arr[l++];
      } else {
        if (r < N) sum += arr[r++];
        else break;
      }
    }
    result.append(length == Integer.MAX_VALUE ? 0 : length);
  }
}