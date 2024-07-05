import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  int N, max, min;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    max = 0;
    min = Integer.MAX_VALUE;
    br.close();
  }

  void solution() {
    dfs(N, countOddNumber(N));
  }

  void dfs(int n, int count) {
    int length1 = getNumberLength(n);
    if (length1 == 1) {
      max = Integer.max(max, count);
      min = Integer.min(min, count);
      return;
    }

    if (length1 == 2) {
      int[] temp1 = sliceNumber(n, 1);
      int next = temp1[0] + temp1[1];
      dfs(next, count + countOddNumber(next));
      return;
    }

    for (int i = 1; i < length1 - 1; i++) {
      int[] temp1 = sliceNumber(n, i);

      int length2 = getNumberLength(temp1[0]);
      if (length2 == 1) {
        int next = temp1[0] + temp1[1];
        dfs(next, count + countOddNumber(next));
        continue;
      }

      for (int j = 1; j <= length2 - 1; j++) {
        int[] temp2 = sliceNumber(temp1[0], j);
        int next = temp1[1] + temp2[0] + temp2[1];
        dfs(next, count + countOddNumber(next));
      }
    }
  }

  int getNumberLength(int n) {
    return (int) Math.log10(n) + 1;
  }

  int[] sliceNumber(int n, int i) {
    return new int[]{n / (int) Math.pow(10, i), n % (int) Math.pow(10, i)};
  }

  int countOddNumber(int n) {
    int temp = n;
    int count = 0;
    while (temp != 0) {
      if (temp % 10 % 2 == 1) count++;
      temp = temp / 10;
    }
    return count;
  }

  void result() {
    System.out.println(min + " " + max);
  }

  void run() throws IOException {
    init();
    solution();
    result();
  }

  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}