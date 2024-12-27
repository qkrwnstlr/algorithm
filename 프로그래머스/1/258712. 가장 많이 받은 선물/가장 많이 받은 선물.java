import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
  public int solution(String[] friends, String[] gifts) {
    int answer = 0;
    parse(friends, gifts);
    for (int i = 0; i < N; i++) answer = Math.max(answer, calculate(i));
    return answer;
  }

  int N;
  int[][] counts;
  Map<String, Integer> index;

  public void parse(String[] friends, String[] gifts) {
    N = friends.length;

    index = new HashMap<>();
    for (int i = 0; i < N; i++) index.put(friends[i], i);

    counts = new int[N][N + 1];
    for (String gift : gifts) {
      StringTokenizer st = new StringTokenizer(gift);
      int from = index.get(st.nextToken());
      int to = index.get(st.nextToken());

      counts[from][to]++;
      counts[from][N]++;
      counts[to][N]--;
    }
  }

  public int calculate(int index) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (counts[index][i] > counts[i][index]) count++;
      else if (counts[index][i] == counts[i][index] && counts[index][N] > counts[i][N]) count++;
    }
    return count;
  }
}