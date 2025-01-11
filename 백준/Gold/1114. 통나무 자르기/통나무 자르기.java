import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int L, C, K;
  int[] arr;
  StringBuilder result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    Set<Integer> set = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) set.add(Integer.parseInt(st.nextToken()));
    arr = set.stream().sorted(Collections.reverseOrder()).mapToInt(it -> it).toArray();
  }

  void solution() {
    int l = 1, r = L;
    while (l < r) {
      int mid = (l + r) / 2;
      if (check(mid) > 0) r = mid;
      else l = mid + 1;
    }
    result.append(l).append(" ").append(check(l));
  }

  int check(int target) {
    int wood = L, count = K;
    int before = 0, current = 0;
    while (count > 0 && current < arr.length) {
      while (current < arr.length && wood - arr[current] <= target) current++;
      if (current == before) return -1;
      count--;
      wood = arr[current - 1];
      before = current;
    }

    if (count > 0) wood = arr[arr.length - 1];

    if (wood > target) return -1;
    return wood;
  }
}
