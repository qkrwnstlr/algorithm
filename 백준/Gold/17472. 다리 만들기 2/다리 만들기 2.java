import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, M, result;
  int[][] table;
  List<Map<Integer, Integer>> graph;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    result = 0;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    table = new int[N][M];
    for (int i = 0; i < N; i++) {
      table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    graph = new ArrayList<>();
    graph.add(new HashMap<>());
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    parseTable();
    parseGraph();
    prim();
  }

  void parseTable() {
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    boolean[][] visited = new boolean[N][M];
    int id = 1;

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (table[r][c] == 0 || visited[r][c]) continue;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(r * M + c);
        while (!q.isEmpty()) {
          int ci = q.poll(), cr = ci / M, cc = ci % M;
          table[cr][cc] = id;
          visited[cr][cc] = true;
          for (int d = 0; d < dr.length; d++) {
            int nr = cr + dr[d], nc = cc + dc[d];
            if (!isExist(nr, nc) || visited[nr][nc] || table[nr][nc] == 0) continue;
            q.add(nr * M + nc);
          }
        }
        graph.add(new HashMap<>());
        id++;
      }
    }
  }

  void parseGraph() {
    int[] dr = {0, 1}, dc = {1, 0};

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        if (table[r][c] == 0) continue;
        dLoop:
        for (int d = 0; d < dr.length; d++) {
          int nr = r + dr[d], nc = c + dc[d], length = 0;
          if (!isExist(nr, nc) || table[r][c] == table[nr][nc]) continue;
          while (table[nr][nc] == 0) {
            nr += dr[d];
            nc += dc[d];
            length++;
            if (!isExist(nr, nc)) continue dLoop;
          }
          if (length >= 2) {
            graph.get(table[r][c]).put(table[nr][nc],
              Math.min(length, graph.get(table[r][c]).getOrDefault(table[nr][nc], Integer.MAX_VALUE)));
            graph.get(table[nr][nc]).put(table[r][c],
              Math.min(length, graph.get(table[nr][nc]).getOrDefault(table[r][c], Integer.MAX_VALUE)));
          }
        }
      }
    }
  }

  void prim() {
    boolean[] visited = new boolean[graph.size()];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(1, 0));
    while (!pq.isEmpty()) {
      Edge e = pq.poll();
      if (visited[e.v]) continue;
      visited[e.v] = true;
      result += e.length;
      Map<Integer, Integer> edges = graph.get(e.v);
      edges.forEach((v, length) -> {
        if (!visited[v]) pq.add(new Edge(v, length));
      });
    }

    for (int i = 1; i < visited.length; i++) {
      if (!visited[i]) {
        result = -1;
        return;
      }
    }
  }

  boolean isExist(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M;
  }
}

class Edge implements Comparable<Edge> {
  int v, length;

  Edge(int v, int length) {
    this.v = v;
    this.length = length;
  }

  @Override
  public int compareTo(Edge o) {
    return this.length - o.length;
  }
}