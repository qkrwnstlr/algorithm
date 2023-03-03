package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1707 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int v;
  static int e;
  static Node[] graph;
  static int[] visited;

  static class Node {
    int data;
    HashSet<Integer> link;

    Node(int data) {
      this.data = data;
      link = new HashSet<>();
    }
  }

  public static void initGraph() throws IOException {
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    graph = new Node[v + 1];
    for (int i = 1; i <= v; i++) {
      graph[i] = new Node(i);
    }

    visited = new int[v + 1];
    Arrays.fill(visited, -1);

    for (int j = 0; j < e; j++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].link.add(v2);
      graph[v2].link.add(v1);
    }
  }

  static Queue<Integer> queue;

  static void setVisited(int current, int group) {
    queue.add(current);
    visited[current] = group;
  }

  public static boolean bfs() {
    queue = new LinkedList<>();
    for (int i = 1; i <= v; i++) {
      if (visited[i] != -1) continue;
      setVisited(i, 0); // 여기로 왔다 -> 기존에는 연결된 곳이 없다 -> 0부터 시작해도 괜찮음
      while (!queue.isEmpty()) {
        int current = queue.remove();
        int nextGroup = (visited[current] + 1) % 2;
        for (int key : graph[current].link) {
          if (visited[key] == -1) setVisited(key, nextGroup);
          else if (visited[key] == visited[current]) return false;
        }
      }
    }
    return true;
  }

  public static void result() throws IOException {
    StringBuilder sb = new StringBuilder();
    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      initGraph();
      sb.append(bfs() ? "YES" : "NO").append("\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
