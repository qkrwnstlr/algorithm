import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, total;
  int[] counts, result;
  Ball[] balls;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    balls = new Ball[N];
    counts = new int[N + 1];
    result = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    br.close();
  }

  void printResult() {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(result).forEach(it -> sb.append(it).append("\n"));
    System.out.println(sb);
  }

  void solution() {
    Arrays.sort(balls);

    for (int i = 0; i < N; ) {
      Ball current = balls[i];

      int j = 0;
      while (i + j < N && current.size == balls[i + j].size) {
        result[balls[i + j].index] = total - counts[balls[i + j].color];
        j++;
      }

      for (int k = 0; k < j; k++) {
        total += balls[i + k].size;
        counts[balls[i + k].color] += balls[i + k].size;
      }

      i += j;
    }
  }
}

class Ball implements Comparable<Ball> {
  int index, color, size;

  Ball(int index, int color, int size) {
    this.index = index;
    this.color = color;
    this.size = size;
  }

  @Override
  public int compareTo(Ball o) {
    return size == o.size ? Integer.compare(color, o.color) : Integer.compare(size, o.size);
  }
}