import java.util.Arrays;

class Solution {
  public int[] solution(int n, int[] info) {
    init(n, info);
    answer = dfs(n, 0, 0, new int[11]).shot;
    return answer;
  }

  int n;
  int[] info, answer;

  void init(int n, int[] info) {
    this.n = n;
    this.info = info;
  }

  Lion dfs(int n, int score, int depth, int[] shot) {
    if (n < 0) return Lion.empty();

    if (depth == 11) {
      shot[10] += n;

      int apeach = 0;
      for (int i = 0; i < 11; i++) {
        if (shot[i] == 0 && info[i] != 0) apeach += 10 - i;
      }

      return apeach < score ? new Lion(score - apeach, Arrays.copyOf(shot, 11)) : Lion.empty();
    }

    shot[depth] = info[depth] + 1;
    Lion l1 = dfs(n - (info[depth] + 1), score + (10 - depth), depth + 1, shot);

    shot[depth] = 0;
    Lion l2 = dfs(n, score, depth + 1, shot);

    return Lion.max(l1, l2);
  }
}

class Lion {
  int score;
  int[] shot;

  Lion(int score, int[] shot) {
    this.score = score;
    this.shot = shot;
  }

  static Lion empty() {
    return new Lion(-1, new int[]{-1});
  }

  static Lion max(Lion l1, Lion l2) {
    if (l1.score == -1) return l2;
    if (l2.score == -1) return l1;
    if (l1.score == l2.score) {
      for (int i = 10; i >= 0; i--) {
        if (l1.shot[i] == l2.shot[i]) continue;
        return l1.shot[i] > l2.shot[i] ? l1 : l2;
      }
    }
    return l1.score > l2.score ? l1 : l2;
  }
}