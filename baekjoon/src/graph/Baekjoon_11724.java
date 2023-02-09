package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11724 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] graph = new int[n][n];

    for (int i = 0; i < m; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    int[] checkedList = new int[n];
    int checked = 0;
    int count = 1;
    int current = 0;
    int next;

    while (true) {
      checkedList[current] = count;
      checked++;
      if (checked == n) break;
      for (next = 0; next < n; next++) {
        if (checkedList[next] != 0 || graph[current][next] != 1) continue;
        for (int i = 0; i < n; i++) {
          graph[next][i] = Math.max(graph[next][i], graph[current][i]);
        }
        current = next;
        break;
      }
      if (current != next) {
        count++;
        for (int i = 0; i < n; i++) {
          if (checkedList[i] == 0) {
            current = i;
            break;
          }
        }
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
