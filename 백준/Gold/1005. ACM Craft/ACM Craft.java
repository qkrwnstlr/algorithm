import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder result;
  int N, K, W;
  int[] D, count;
  List<List<Integer>> graph1, graph2;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    D = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) D[i] = Integer.parseInt(st.nextToken());

    count = new int[N + 1];
    graph1 = new ArrayList<>();
    graph2 = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph1.add(new ArrayList<>());
      graph2.add(new ArrayList<>());
    }
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());
      graph1.get(X).add(Y);
      graph2.get(Y).add(X);
      count[Y]++;
    }
    W = Integer.parseInt(br.readLine());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int test = 0; test < T; test++) {
      init();
      solution();
    }
    System.out.println(result);

    br.close();
  }

  void solution() {
    Queue<Integer> queue = new ArrayDeque<>();
    int[] time = new int[N + 1];
    for (int i = 1; i <= N; i++) if (count[i] == 0) queue.add(i);
    while (!queue.isEmpty()) {
      int current = queue.poll();
      time[current] = Math.max(time[current], graph2.get(current).stream().mapToInt(it -> time[it]).max().orElse(0)) + D[current];
      graph1.get(current).forEach(it -> {
        if (--count[it] == 0) queue.add(it);
      });
    }
    result.append(time[W]).append("\n");
  }
}