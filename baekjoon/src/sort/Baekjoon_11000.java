package sort;

import java.io.*;
import java.util.*;

public class Baekjoon_11000 {
  static class Time implements Comparable<Time> {
    int from;
    int to;

    Time(int from, int to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public int compareTo(Time o) {
      return this.from - o.from == 0 ? this.to - o.to : this.from - o.from;
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    Time[] times = new Time[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      times[i] = new Time(start, end);
    }
    Arrays.sort(times);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(times[0].to);
    for (int i = 1; i < n; i++) {
      assert pq.peek() != null;
      if (pq.peek() <= times[i].from) {
        pq.poll();
      }
      pq.offer(times[i].to);
    }
    System.out.println(pq.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
