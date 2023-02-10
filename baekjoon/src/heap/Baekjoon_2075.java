package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_2075 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      for (int j = 0; j < n; j++) {
        queue.add(Integer.parseInt(st.nextToken()));
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) if (!queue.isEmpty()) result = queue.poll();

    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
