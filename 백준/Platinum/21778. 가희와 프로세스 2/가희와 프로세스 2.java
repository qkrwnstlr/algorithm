import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int Q, N;
  long MAX = 1000000000001L;
  long[] T, result;
  Process[] processes;
  BufferedReader br;
  Map<Long, Long> dp;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    Q = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    processes = new Process[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      processes[i] = new Process(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()) + MAX);
    }
    Arrays.sort(processes);

    T = new long[Q];
    for (int i = 0; i < Q; i++) T[i] = Long.parseLong(br.readLine());

    result = new long[Q];

    dp = new HashMap<>();
  }

  void printResult() {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(result).forEach(it -> sb.append(it).append("\n"));
    System.out.println(sb);
  }

  void solution() {
    for (int i = 0; i < Q; i++) {
      result[i] = search(T[i]);
    }
  }

  long getTime(long w) {
    if (dp.containsKey(w)) return dp.get(w);

    long total = 0;
    for (int i = 0; i < N; i++) {
      Process process = processes[i];
      long s = process.weight, e = process.weight - process.time + 1;
      if (w <= e) total += process.time;
      else if (w <= s) total += s - w + 1;
    }

    dp.put(w, total);
    return total;
  }

  long search(long t) {
    long left = 0, right = Long.MAX_VALUE;

    while (left <= right) {
      long mid = (left + right) / 2;
      if (getTime(mid) >= t) {
        if (getTime(mid + 1) < t) {
          List<Long> list = new ArrayList<>();
          for (int i = 0; i < N; i++) {
            Process process = processes[i];
            if (process.weight - process.time < mid && mid <= process.weight) list.add(process.id);
          }
          return list.get((int) (t - getTime(mid + 1) - 1));
        } else {
          left = mid + 1;
        }
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }
}

class Process implements Comparable<Process> {
  long id, time, weight;

  Process(long id, long time, long weight) {
    this.id = id;
    this.time = time;
    this.weight = weight;
  }

  @Override
  public int compareTo(Process o) {
    return Long.compare(id, o.id);
  }
}