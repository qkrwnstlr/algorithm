package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_4485 {
  static class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      if (this.distance < o.distance) {
        return -1;
      }
      return 1;
    }
  }

  static int n;
  static int[] table;
  static ArrayList<ArrayList<Node>> graph;

  static int[] d;

  static void initGraph() {
    for (int i = 0; i < n * n; i++) {
      graph.add(new ArrayList<>());
      if (i % n != 0) graph.get(i).add(new Node(i - 1, table[i - 1]));
      if (i / n != 0) graph.get(i).add(new Node(i - n, table[i - n]));
      if (i % n != n - 1) graph.get(i).add(new Node(i + 1, table[i + 1]));
      if (i / n != n - 1) graph.get(i).add(new Node(i + n, table[i + n]));
    }
  }

  static int dijkstra(int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    /* 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입 */
    pq.offer(new Node(0, 0));
    d = new int[n * n];
    Arrays.fill(d, Integer.MAX_VALUE);
    d[0] = 0;

    /* 큐가 비어있지않을 때까지 반복 */
    while (!pq.isEmpty()) {
      /* 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기 */
      Node node = pq.poll();

      int dist = node.distance; // 현재 노드까지의 비용
      int now = node.index; // 현재 노드 번호

      /* 현재 노드가 이미 처리된 적이 있는 노드라면 무시 */
      if (d[now] < dist) {
        continue;
      }

      /* 현재 노드와 연결된 다른 인접한 노드들을 확인 */
      for (int i = 0; i < graph.get(now).size(); i++) {
        /* 현재의 최단거리 + 현재의 연결된 노드의 비용 */
        int cost = d[now] + graph.get(now).get(i).distance;

        /* 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 */
        if (cost < d[graph.get(now).get(i).index]) {
          d[graph.get(now).get(i).index] = cost;
          pq.offer(new Node(graph.get(now).get(i).index, cost));
        }
      }
    }
    return d[end];
  }

  static void result() throws IOException {
    int count = 1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String str = br.readLine();
      n = Integer.parseInt(str);
      if (n == 0) break;
      table = new int[n * n];
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int j = 0; j < n; j++) table[i * n + j] = Integer.parseInt(st.nextToken());
      }
      initGraph();
      System.out.println("Problem " + (count++) + ": " + (dijkstra(n * n - 1) + table[0]));
    }
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
