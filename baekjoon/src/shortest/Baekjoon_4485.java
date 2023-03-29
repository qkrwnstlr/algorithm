package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
  static int[][] table;
  static ArrayList<ArrayList<Node>> graph;

  static void result() throws IOException {
    int count = 1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String str = br.readLine();
      n = Integer.parseInt(str);
      if (n == 0) break;
      table = new int[n][n];
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        str = br.readLine();
        graph.add(new ArrayList<>());
        StringTokenizer st = new StringTokenizer(str);
        for (int j = 0; j < n; j++) table[i][j] = Integer.parseInt(st.nextToken());
      }
      // TODO : Graph 초기화
      // TODO : 최단거리 구하기
      System.out.println("Problem " + (count++) + ": ");
    }
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
