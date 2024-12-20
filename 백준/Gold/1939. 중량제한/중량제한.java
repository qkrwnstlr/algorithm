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
  int N, M, u, v;
  List<Map<Integer, Integer>> graph;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) graph.add(new HashMap<>());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      try {
        graph.get(A).put(B, Math.max(graph.get(A).get(B), C));
      } catch (Exception e) {
        graph.get(A).put(B, C);
      }
      try {
        graph.get(B).put(A, Math.max(graph.get(B).get(A), C));
      } catch (Exception e) {
        graph.get(B).put(A, C);
      }
    }
    st = new StringTokenizer(br.readLine());
    u = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void solution() {
    boolean[] visited = new boolean[N + 1];
    int[] weight = new int[N + 1];
    PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
    visited[u] = true;

    graph.get(u).forEach((v, w) -> {
      weight[v] = w;
      pq.add(new Edge(v, weight[v]));
    });

    while (!pq.isEmpty()) {
      Edge u = pq.poll();
      if (visited[u.v]) continue;
      visited[u.v] = true;
      graph.get(u.v).forEach((v, w) -> {
        int next = Math.min(weight[u.v], w);
        if (!visited[v] && next > weight[v]) {
          weight[v] = next;
          pq.add(new Edge(v, weight[v]));
        }
      });
    }
    result.append(weight[v]);
  }
}

class Edge implements Comparable<Edge> {
  int v, w;

  Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    return Integer.compare(this.w, o.w);
  }
}