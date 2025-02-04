import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;
  NodePool nodePool;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    nodePool = new NodePool(N);
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      nodePool.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    Edge f1 = nodePool.getFarthestNode(1, 0);
    Edge f2 = nodePool.getFarthestNode(f1.index, 0);

    Edge f3 = nodePool.getFarthestNode(f1.index, f2.index);
    Edge f4 = nodePool.getFarthestNode(f2.index, f1.index);

    result = Math.max(f3.distance, f4.distance);
  }
}

class NodePool {
  Node[] nodes;

  NodePool(int size) {
    nodes = new Node[size + 1];
    for (int i = 1; i <= size; i++) nodes[i] = new Node(i);
  }

  void addEdge(int from, int to, int distance) {
    nodes[from].addEdge(to, distance);
    nodes[to].addEdge(from, distance);
  }

  Edge getFarthestNode(int from, int exclude) {
    boolean[] visited = new boolean[nodes.length];

    Queue<Edge> queue = new ArrayDeque<>();

    Edge result = new Edge(from, 0);
    queue.add(result);
    visited[from] = true;
    visited[exclude] = true;

    while (!queue.isEmpty()) {
      Edge current = queue.poll();
      if (current.distance > result.distance) result = current;

      List<Edge> edges = nodes[current.index].edges;
      for (int i = 0; i < edges.size(); i++) {
        Edge next = edges.get(i);
        if (!visited[next.index]) {
          queue.add(new Edge(next.index, current.distance + next.distance));
          visited[next.index] = true;
        }
      }
    }

    return result;
  }
}

class Node {
  int index;
  List<Edge> edges;

  Node(int index) {
    this.index = index;
    this.edges = new ArrayList<>();
  }

  void addEdge(int to, int distance) {
    edges.add(new Edge(to, distance));
  }
}

class Edge {
  int index, distance;

  Edge(int index, int distance) {
    this.index = index;
    this.distance = distance;
  }
}