import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int K;
  static int[] exercises;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    exercises = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) exercises[i] = Integer.parseInt(st.nextToken());

    start(0, 500);

    System.out.println(count);
  }

  static void start(int depth, int current) {
    if (current < 500) return;
    if (depth == N) {
      count++;
      return;
    }
    for (int i = 0; i < N; i++) {
      if (exercises[i] == 0) continue;
      int temp = exercises[i];
      exercises[i] = 0;
      start(depth + 1, current + temp - K);
      exercises[i] = temp;
    }
  }
}