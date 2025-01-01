import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M, X, result;
  Graph graph1, graph2;

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
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    graph1 = new Graph(N + 1);
    graph2 = new Graph(N + 1);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph1.addEdge(from, to, weight);
      graph2.addEdge(to, from, weight);
    }
  }

  void solution() {
    int[] go = graph1.dijkstra(X), back = graph2.dijkstra(X), goBack = new int[N + 1];
    for (int i = 1; i <= N; i++) goBack[i] = go[i] + back[i];
    result = Arrays.stream(goBack).max().orElse(0);
  }
}

class Graph {
  Vertex[] vertices;

  Graph(int n) {
    vertices = new Vertex[n];
    for (int i = 1; i < n; i++) vertices[i] = new Vertex(i);
  }

  void addEdge(int from, int to, int weight) {
    vertices[from].addEdge(to, weight);
  }

  int[] dijkstra(int index) {
    boolean[] visited = new boolean[vertices.length];
    int[] distance = new int[vertices.length];
    Arrays.fill(distance, Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();

    pq.add(new Node(index, 0));
    distance[0] = 0;
    distance[index] = 0;

    while (!pq.isEmpty()) {
      int current = pq.poll().index;
      if (visited[current]) continue;
      visited[current] = true;

      vertices[current].edges.forEach(next -> {
        if (!visited[next.index] && distance[next.index] > distance[current] + next.weight) {
          distance[next.index] = distance[current] + next.weight;
          pq.add(new Node(next.index, distance[next.index]));
        }
      });
    }

    return distance;
  }
}

class Vertex {
  int index;
  List<Node> edges;

  Vertex(int index) {
    this.index = index;
    edges = new ArrayList<>();
  }

  void addEdge(int to, int weight) {
    edges.add(new Node(to, weight));
  }
}

class Node implements Comparable<Node> {
  int index, weight;

  Node(int index, int weight) {
    this.index = index;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(weight, o.weight);
  }
}