import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int K, N;
  int[] arr;
  long result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    TreeSet<Long> pq = new TreeSet<>();
    Arrays.stream(arr).forEach(it -> pq.add((long) it));
    while (--N >= 0 && !pq.isEmpty()) {
      result = pq.pollFirst();
      for (int i = 0; i < K; i++) {
        long next = result * arr[i];
        if (pq.size() >= N && !pq.isEmpty() && pq.last() <= next) break;
        pq.add(next);
      }
    }
  }
}
