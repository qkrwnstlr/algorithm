import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, L, P, result;
  int[] arr;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    result = 0;
    N = Integer.parseInt(st.nextToken());
    arr = new int[1000001];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int curr = 0, next = P;

    while (curr + next < L) {
      for (int i = curr + 1; i <= curr + next; i++) {
        if (arr[i] != 0) pq.add(arr[i]);
      }

      if (pq.isEmpty()) {
        result = -1;
        return;
      }

      result++;
      curr += next;
      next = pq.poll();
    }
  }
}