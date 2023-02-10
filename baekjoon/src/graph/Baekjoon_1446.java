package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1446 {
  static class Road {
    int destination;
    int distance;

    Road(int destination, int distance) {
      this.destination = destination;
      this.distance = distance;
    }
  }

  static ArrayList<ArrayList<Road>> highway = new ArrayList<>();

  static void dijkstra() {
    int[] dist = new int[highway.size()]; // 시작위치 -> 특정위치 거리
    Arrays.fill(dist, Integer.MAX_VALUE);

    // 우선순위 큐, 최소값으로 정렬, 다음 방문할 노드
    PriorityQueue<Road> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    dist[0] = 0; // 시작위치 -> 시작위치의 거리 = 0
    q.add(new Road(0, dist[0])); // 시작위치 지정

    boolean[] visited = new boolean[highway.size()]; // 방문 여부

    while (!q.isEmpty()) {
      Road now = q.poll(); // 현재 방문중인 노드

      if (!visited[now.destination]) {
        visited[now.destination] = true; // 방문 설정
      }

      for (Road next : highway.get(now.destination)) { // 모든 노드에 대해서
        if (!visited[next.destination] && dist[next.destination] > now.distance + next.distance) { // 아직 방문한한 노드고 지금보다 짧으면
          dist[next.destination] = now.distance + next.distance;
          q.add(new Road(next.destination, dist[next.destination]));
        }
      }
    }

    System.out.println(dist[highway.size() - 1]);
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < d; i++) { // 1km 마다 노드 생성 및 초기화
      highway.add(new ArrayList<>());
      highway.get(i).add(new Road(i + 1, 1));
    }
    highway.add(new ArrayList<>());
    highway.get(d).add(new Road(0, d));

    for (int i = 0; i < n; i++) { // 지름길 생성 및 삽입
      str = br.readLine();
      st = new StringTokenizer(str);

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());

      if (from >= 0 && to <= d) highway.get(from).add(new Road(to, dist));
    }

    dijkstra(); // 출발지부터 최단거리 계산
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
