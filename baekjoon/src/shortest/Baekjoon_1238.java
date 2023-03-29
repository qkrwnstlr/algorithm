package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1238 {
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

  static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    /* 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입 */
    pq.offer(new Node(start, 0));

    d[start][start] = 0;

    /* 큐가 비어있지않을 때까지 반복 */
    while (!pq.isEmpty()) {
      /* 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기 */
      Node node = pq.poll();

      int dist = node.distance; // 현재 노드까지의 비용
      int now = node.index; // 현재 노드 번호

      /* 현재 노드가 이미 처리된 적이 있는 노드라면 무시 */
      if (d[start][now] < dist) {
        continue;
      }

      /* 현재 노드와 연결된 다른 인접한 노드들을 확인 */
      for (int i = 0; i < graph.get(now).size(); i++) {
        /* 현재의 최단거리 + 현재의 연결된 노드의 비용 */
        int cost = d[start][now] + graph.get(now).get(i).distance;

        /* 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 */
        if (cost < d[start][graph.get(now).get(i).index]) {
          d[start][graph.get(now).get(i).index] = cost;
          pq.offer(new Node(graph.get(now).get(i).index, cost));
        }
      }
    }
  }

  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[][] d;

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    d = new int[n][n];
    for (int i = 0; i < n; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(start - 1).add(new Node(end - 1, Integer.parseInt(st.nextToken())));
    }
    int max = 0;
    for (int i = 0; i < n; i++) dijkstra(i);
    for (int i = 0; i < n; i++) max = Integer.max(max, d[i][x - 1] + d[x - 1][i]);
    System.out.println(max);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
