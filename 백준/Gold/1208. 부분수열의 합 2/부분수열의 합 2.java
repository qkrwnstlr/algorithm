import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, S;
  long result;
  int[] arr;

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
    S = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    Map<Integer, Integer> counts = new HashMap<>();
    bfs(0, 0, N / 2, it -> counts.put(it, counts.getOrDefault(it, 0) + 1));
    bfs(N / 2, 0, N, it -> result += counts.getOrDefault(S - it, 0));
    if (S == 0) result--;
  }

  void bfs(int index, int sum, int limit, Consumer<Integer> callback) {
    if (index == limit) {
      callback.accept(sum);
      return;
    }
    bfs(index + 1, sum, limit, callback);
    bfs(index + 1, sum + arr[index], limit, callback);
  }
}