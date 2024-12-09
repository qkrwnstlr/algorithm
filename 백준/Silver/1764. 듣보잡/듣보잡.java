import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M;

  Set<String> emeeh, qheh, result;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    emeeh = new HashSet<>();
    for (int i = 0; i < N; i++) emeeh.add(br.readLine());
    qheh = new HashSet<>();
    for (int i = 0; i < M; i++) qheh.add(br.readLine());
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result.size()).append("\n");
    result.stream().sorted().forEach(it -> sb.append(it).append("\n"));

    System.out.println(sb);

    br.close();
  }

  void solution() {
    result = new HashSet<>(emeeh);
    result.retainAll(qheh);
  }
}