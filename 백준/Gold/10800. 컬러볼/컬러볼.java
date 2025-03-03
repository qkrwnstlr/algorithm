import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, total;
  int[] counts, result;
  List<List<Ball>> balls;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    balls = new ArrayList<>();
    counts = new int[N + 1];
    result = new int[N];

    for (int i = 0; i <= 2000; i++) {
      balls.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int color = Integer.parseInt(st.nextToken()), size = Integer.parseInt(st.nextToken());
      balls.get(size).add(new Ball(i, color));
    }

    br.close();
  }

  void printResult() {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(result).forEach(it -> sb.append(it).append("\n"));
    System.out.println(sb);
  }

  void solution() {
    for (int i = 1; i <= 2000; i++) {
      List<Ball> list = balls.get(i);
      for (int j = 0; j < list.size(); j++) {
        result[list.get(j).index] = total - counts[list.get(j).color];
      }

      for (int j = 0; j < list.size(); j++) {
        counts[list.get(j).color] += i;
      }

      total += list.size() * i;
    }
  }
}

class Ball implements Comparable<Ball> {
  int index, color;

  Ball(int index, int color) {
    this.index = index;
    this.color = color;
  }

  @Override
  public int compareTo(Ball o) {
    return Integer.compare(color, o.color);
  }
}