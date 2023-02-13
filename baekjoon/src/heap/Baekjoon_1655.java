package heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_1655 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int median;
  static PriorityQueue<Integer> over = new PriorityQueue<>(Comparator.comparingInt(i -> i)); // 더 큰 값들을 작은 순서대로 정렬
  static PriorityQueue<Integer> low = new PriorityQueue<>((i1, i2) -> i2 - i1); // 더 작은 값들을 큰 순서대로 정렬

  static int input() throws IOException {
    return Integer.parseInt(br.readLine());
  }

  static void result() throws IOException {
    int n = input();
    median = input();
    bw.write(String.valueOf(median));
    bw.write('\n');

    for (int i = 1; i < n; i++) {
      int input = input();
      if (input > median) over.add(input);
      else low.add(input);
      if(low.size() > over.size()) {
        over.add(median);
        median = low.poll();
      } else if(over.size() > low.size() + 1) {
        low.add(median);
        median = over.poll();
      }
      bw.write(String.valueOf(median));
      bw.write('\n');
    }
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
