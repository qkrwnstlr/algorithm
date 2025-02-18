import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int W, H, N, result;
  Plate[] plates;
  int[][] dp;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(br.readLine());

    plates = new Plate[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      plates[i] = new Plate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    dp = new int[W + 1][H + 1];
    for (int i = 1; i <= W; i++) Arrays.fill(dp[i], -1);
    dp[0][0] = 0;
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    result = solve(W, H);
  }

  int solve(int w, int h) {
    if (dp[w][h] != -1) return dp[w][h];

    dp[w][h] = w * h;
    for (int i = 0; i < N; i++) {
      if (plates[i].w > w || plates[i].h > h) continue;

      int nw = w - plates[i].w, nh = h - plates[i].h;
      int wh = solve(nw, h) + solve(plates[i].w, nh), hw = solve(w, nh) + solve(nw, plates[i].h);
      dp[w][h] = Math.min(dp[w][h], Math.min(wh, hw));
    }

    return dp[w][h];
  }
}

class Plate {
  int w, h;

  Plate(int w, int h) {
    this.w = w;
    this.h = h;
  }
}
