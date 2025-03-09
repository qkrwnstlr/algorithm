import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, M;
  StringBuilder result;
  BufferedReader br;
  int[] topology;
  List<List<Integer>> graph;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    result = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    topology = new int[N + 1];
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
      topology[e]++;
      graph.get(s).add(e);
    }
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (topology[i] == 0) pq.add(i);
    }

    while (!pq.isEmpty()) {
      int current = pq.poll();
      result.append(current).append(" ");
      graph.get(current).forEach(it -> {
        if (--topology[it] == 0) pq.add(it);
      });
    }
  }
}