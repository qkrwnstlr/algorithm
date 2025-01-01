import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M;
  Set<Integer> middle;
  int[] result;
  NodePool graph;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();
    solution();
    for (int i = 1; i <= N; i++) {
      if (!middle.contains(i)) sb.append(i).append(" ").append(result[i]).append("\n");
    }
    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    middle = new HashSet<>();
    graph = new NodePool(N + 1);
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int to = Integer.parseInt(st.nextToken());
      int from = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph.addEdge(from, to, weight);
      middle.add(to);
    }
    result = new int[N + 1];
    result[N] = 1;
  }

  void solution() {
    calculate(graph.get(N));
  }

  void calculate(Node node) {
    node.parents.forEach(it -> {
      result[it.num] += graph.getWeight(it, node) * result[node.num];
      it.children.remove(node);
      if (it.children.isEmpty()) calculate(it);
    });
  }
}

class NodePool {
  private final Node[] nodes;
  private final int[][] graph;

  NodePool(int n) {
    nodes = new Node[n];
    graph = new int[n][n];
    for (int i = 1; i < n; i++) nodes[i] = new Node(i);
  }

  Node get(int index) {
    return nodes[index];
  }

  void addEdge(int from, int to, int weight) {
    nodes[from].addChild(nodes[to]);
    graph[from][to] = weight;
  }

  int getWeight(Node from, Node to) {
    return getWeight(from.num, to.num);
  }

  int getWeight(int from, int to) {
    return graph[from][to];
  }
}

class Node {
  int num;
  List<Node> children, parents;

  Node(int num) {
    this.num = num;
    this.children = new ArrayList<>();
    this.parents = new ArrayList<>();
  }

  private void addParent(Node node) {
    parents.add(node);
  }

  void addChild(Node node) {
    this.children.add(node);
    node.addParent(this);
  }
}