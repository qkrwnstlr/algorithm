import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;
  String[] words;
  int[][] dp;


  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    words = new String[N];
    for (int i = 0; i < N; i++) words[i] = br.readLine();
    dp = new int[5][1 << N];
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 5; j++) Arrays.fill(dp[j], -1);
      result = Math.max(result, dfs(i, 1 << i) + words[i].length());
    }
  }

  int dfs(int lastWord, int visited) {
    if (visited == (1 << N) - 1) return 0;
    int lastIndex = getIndex(lastWord, words[lastWord].length() - 1);
    if (dp[lastIndex][visited] != -1) return dp[lastIndex][visited];

    int max = 0;
    for (int i = 0; i < N; i++) {
      if ((visited & (1 << i)) != 0 || lastIndex != getIndex(i, 0)) continue;
      max = Math.max(max, dfs(i, visited | (1 << i)) + words[i].length());
    }
    return dp[lastIndex][visited] = max;
  }

  int getIndex(int current, int index) {
    char character = words[current].charAt(index);
    switch (character) {
      case 'A':
        return 0;
      case 'E':
        return 1;
      case 'I':
        return 2;
      case 'O':
        return 3;
      default:
        return 4;
    }
  }
}