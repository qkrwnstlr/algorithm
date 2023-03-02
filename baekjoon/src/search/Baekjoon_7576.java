package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7576 {
  static int m;
  static int n;
  static short[] box;
  static Queue<Integer> currentQueue = new LinkedList<>();
  static Queue<Integer> beforeQueue = new LinkedList<>();

  public static void setVisited(int index) {
    box[index] = 1;
    if (index / m != n - 1 && box[index + m] == 0) currentQueue.add(index + m);
    if (index / m != 0 && box[index - m] == 0) currentQueue.add(index - m);
    if (index % m != m - 1 && box[index + 1] == 0) currentQueue.add(index + 1);
    if (index % m != 0 && box[index - 1] == 0) currentQueue.add(index - 1);
  }

  public static void next() {
    beforeQueue = currentQueue;
    currentQueue = new LinkedList<>();
    while (!beforeQueue.isEmpty()) {
      setVisited(beforeQueue.remove());
    }
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    box = new short[m * n];
    for (short i = 0; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      for (short j = 0; j < m; j++) {
        int current = i * m + j;
        box[current] = (short) Integer.parseInt(st.nextToken());
        if (box[current] == 1) currentQueue.add(current);
      }
    }

    int count = -1;
    while (!currentQueue.isEmpty()) {
      next();
      count++;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (box[i * m + j] == 0) {
          count = -1;
          break;
        }
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
