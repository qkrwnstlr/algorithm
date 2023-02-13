package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_1655 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int median;
  static PriorityQueue<Integer> over = new PriorityQueue<>(Comparator.comparingInt(i -> i)); // 더 큰 값들을 작은 순서대로 정렬
  static PriorityQueue<Integer> low = new PriorityQueue<>((i1, i2) -> i2 - i1); // 더 작은 값들을 큰 순서대로 정렬

  static int input() throws IOException {
    return Integer.parseInt(br.readLine());
  }

  static void result() throws IOException {
    int n = input();
    median = input();
    System.out.println(median);
    for (int i = 1; i < n; i++) {
      int input = input();
      if (input > median) over.add(input);
      else low.add(input);
      if ((n + 1) % 2 == 0 && over.size() - low.size() > 1) { // 지금까지 들어온거의 갯수가 짝수면 over.size가 1더 커야함
        low.add(median);
        if (!over.isEmpty()) median = over.poll();
      } else if (low.size() - over.size() > 0) { // 홀수면 같아야함
        over.add(median);
        if (!low.isEmpty()) median = low.poll();
      }
      System.out.println(median);
    }
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
