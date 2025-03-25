import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M, result;
  Tree tree;
  int[] targets;
  boolean[] visited;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");

    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    result = 0;

    N = Integer.parseInt(br.readLine());

    tree = new Tree(N);
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      tree.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    M = Integer.parseInt(br.readLine());

    targets = new int[M];
    for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(br.readLine());

    visited = new boolean[N + 1];
  }

  void solution() {
    dfs(tree.root, null, 0);
    for (int i = 1; i < M; i++) {
      Node from = tree.get(targets[i - 1]), to = tree.get(targets[i]), stopover = lca(from, to);
      result += from.depth + to.depth - stopover.depth * 2;
    }
  }

  void dfs(Node current, Node before, int depth) {
    visited[current.index] = true;
    current.setDepth(depth);
    current.setParent(before);
    current.neighbors.forEach(it -> {
      if (!visited[it.index]) dfs(it, current, depth + 1);
    });
  }

  Node lca(Node a, Node b) {
    while (a.depth > b.depth) a = a.parent;
    while (a.depth < b.depth) b = b.parent;
    while (a != b) {
      a = a.parent;
      b = b.parent;
    }
    return a;
  }
}

class Tree {
  Node[] nodes;
  Node root;

  Tree(int N) {
    nodes = new Node[N + 1];
    for (int i = 1; i <= N; i++) nodes[i] = new Node(i);
    root = nodes[1];
  }

  void addEdge(int from, int to) {
    nodes[from].addNeighbor(nodes[to]);
    nodes[to].addNeighbor(nodes[from]);
  }

  Node get(int index) {
    return nodes[index];
  }
}

class Node {
  int index, depth;
  Node parent;
  List<Node> neighbors;

  Node(int index) {
    this.index = index;
    neighbors = new ArrayList<>();
  }

  void addNeighbor(Node neighbor) {
    neighbors.add(neighbor);
  }

  void setParent(Node parent) {
    this.parent = parent;
  }

  void setDepth(int depth) {
    this.depth = depth;
  }
}