package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1162 {
  static class Node implements Comparable<Node> {
    int index;
    Long distance;
    int count;

    Node(int index, Long distance) {
      this.index = index;
      this.distance = distance;
      this.count = 0;
    }

    Node(int index, Long distance, int count) {
      this.index = index;
      this.distance = distance;
      this.count = count;
    }

    @Override
    public int compareTo(Node o) {
      return this.distance.compareTo(o.distance);
    }
  }

  static Long[][] d;

  static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    d = new Long[n][k + 1];
    for (int i = 0; i < n; i++) Arrays.fill(d[i], Long.MAX_VALUE);
    Arrays.fill(d[0], 0L);

    pq.offer(new Node(0, 0L));
    while (!pq.isEmpty()) {
      Node current = pq.poll();
      Long dist = current.distance; // 현재 노드까지의 비용
      int now = current.index; // 현재 노드 번호
      int count = current.count;

      /* 현재 노드가 이미 처리된 적이 있는 노드라면 무시 */
      if (d[now][count] < dist) {
        continue;
      }

      /* 현재 노드와 연결된 다른 인접한 노드들을 확인 */
      for (int i = 0; i < graph.get(now).size(); i++) {
        /* 현재의 최단거리 + 현재의 연결된 노드의 비용 */
        Long cost = d[now][count] + graph.get(now).get(i).distance;

        /* 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 */
        if (cost < d[graph.get(now).get(i).index][count]) {
          d[graph.get(now).get(i).index][count] = cost;
          pq.offer(new Node(graph.get(now).get(i).index, cost, count));
        }

        cost = d[now][count];

        if (count < k && cost < d[graph.get(now).get(i).index][count + 1]) {
          d[graph.get(now).get(i).index][count + 1] = cost;
          pq.offer(new Node(graph.get(now).get(i).index, cost, count+ 1));
        }
      }
    }
  }

  static int n;
  static int m;
  static int k;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      Long distance = Long.parseLong(st.nextToken());
      graph.get(start).add(new Node(end, distance));
      graph.get(end).add(new Node(start, distance));
    }
    dijkstra();
    Long minimum = Long.MAX_VALUE;
    for (int i = 0; i <= k; i++) {
      minimum = Long.min(d[n - 1][i], minimum);
    }
    System.out.println(minimum);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
