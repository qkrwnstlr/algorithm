package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
  static int n;
  static int k;

  static Queue<Integer> queue = new LinkedList<>();
  static int[] visited = new int[100001];

  static void setVisited(int current, int i) {
    queue.add(current);
    visited[current] = i;
  }

  static int BFS() {
    setVisited(n, 0);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      if (current == k) return visited[current];
      if (current - 1 >= 0 && visited[current - 1] == 0) setVisited(current - 1, visited[current] + 1);
      if (current + 1 <= 100000 && visited[current + 1] == 0) setVisited(current + 1, visited[current] + 1);
      if (current * 2 <= 100000 && visited[current * 2] == 0) setVisited(current * 2, visited[current] + 1);
    }
    return Math.abs(n - k);
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    System.out.println(BFS());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
