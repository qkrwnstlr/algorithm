import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  Tree tree;
  StringBuilder result;
  int[][] dp;
  PriorityQueue<Integer> pq;


  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    result = new StringBuilder();
    N = Integer.parseInt(br.readLine());

    dp = new int[N + 1][2];
    pq = new PriorityQueue<>();

    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    tree = new Tree(N, arr);
    tree.addEdge(0, 1);
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      tree.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
  }

  void printResult() {
    result.append(dp[0][0]).append("\n");
    while (!pq.isEmpty()) result.append(pq.poll()).append(" ");
    System.out.println(result);
  }

  void solution() {
    dfs(0, 0, 0);
    trace(0, 0, 0);
  }

  int dfs(int before, int current, int visit) {
    if (dp[current][visit] != 0) return dp[current][visit];

    List<Integer> edges = tree.getEdges(current);

    if (visit == 1) {
      dp[current][visit] += tree.getNode(current);
      for (int i = 0; i < edges.size(); i++) {
        if (edges.get(i) == before) continue;
        dp[current][visit] += dfs(current, edges.get(i), 0);
      }
    } else {
      for (int i = 0; i < edges.size(); i++) {
        if (edges.get(i) == before) continue;
        dp[current][visit] += Math.max(
          dfs(current, edges.get(i), 0),
          dfs(current, edges.get(i), 1)
        );
      }
    }

    return dp[current][visit];
  }

  void trace(int before, int current, int visit) {
    List<Integer> edges = tree.getEdges(current);

    if (visit == 1) {
      pq.add(current);
      for (int i = 0; i < edges.size(); i++) {
        if (edges.get(i) == before) continue;
        trace(current, edges.get(i), 0);
      }
    } else {
      for (int i = 0; i < edges.size(); i++) {
        if (edges.get(i) == before) continue;
        if (dp[edges.get(i)][1] > dp[edges.get(i)][0]) trace(current, edges.get(i), 1);
        else trace(current, edges.get(i), 0);
      }
    }
  }
}

class Tree {
  int[] nodes;
  Map<Integer, List<Integer>> edges;

  Tree(int size, int[] nodes) {
    this.nodes = new int[size + 1];
    for (int i = 1; i <= size; i++) this.nodes[i] = nodes[i - 1];
    edges = new HashMap<>();
    for (int i = 0; i <= size; i++) edges.put(i, new ArrayList<>());
  }

  void addEdge(int a, int b) {
    edges.get(a).add(b);
    edges.get(b).add(a);
  }

  int getNode(int index) {
    return nodes[index];
  }

  List<Integer> getEdges(int index) {
    return edges.get(index);
  }
}