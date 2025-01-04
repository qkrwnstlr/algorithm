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
  int H, W, result;
  int[] height;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    int ll = 0, lr = 1;
    while (lr < W) {
      while (lr < W && height[ll] > height[lr]) lr++;
      if (lr < W) {
        for (int i = ll + 1; i < lr; i++) result += height[ll] - height[i];
        ll = lr;
        lr++;
      }
    }
    int rl = W - 2, rr = W - 1;
    while (rl >= ll) {
      while (rl >= 0 && height[rr] > height[rl]) rl--;
      if (rl >= ll) {
        for (int i = rr - 1; i > rl; i--) result += height[rr] - height[i];
        rr = rl;
        rl--;
      }
    }
  }
}
