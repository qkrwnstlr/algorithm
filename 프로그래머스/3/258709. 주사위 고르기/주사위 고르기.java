import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] solution(int[][] dice) {

    init(dice);
    combDice(0, -1, 0);
    calculate(0, -1, 0);

    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      if (max % 2 == 1) answer.add(i);
      max /= 2;
    }

    return answer.stream().mapToInt(it -> it).toArray();
  }

  int N, maxCount, max;
  int[][] dice;
  Map<Integer, List<Integer>> sums;

  void init(int[][] dice) {
    N = dice.length;
    sums = new HashMap<>();
    this.dice = dice;
  }

  void combDice(int bit, int last, int depth) {
    if (depth == N / 2) {
      sums.put(bit, new ArrayList<>());
      combSpot(bit, bit, 0, -1, 0);
      sums.get(bit).sort(Integer::compare);
      return;
    }

    for (int i = last + 1; i < N; i++) {
      combDice(bit | (1 << i), i, depth + 1);
    }
  }

  void combSpot(int bit, int temp, int sum, int last, int depth) {
    if (depth == N / 2) {
      sums.get(bit).add(sum);
      return;
    }

    for (int i = last + 1; i < N; i++) {
      if (temp % 2 == 1) {
        for (int j = 0; j < 6; j++) {
          combSpot(bit, temp / 2, sum + dice[i][j], i, depth + 1);
        }
      }
      temp /= 2;
    }
  }

  int calculateRate(int bit) {
    int reverse = (1 << N) - bit - 1;
    int max = (int) Math.pow(6, (double) N / 2);
    int count = 0;
    int l = max - 1, r = max - 1;
    while (l >= 0 && r >= 0) {
      if (sums.get(bit).get(l) > sums.get(reverse).get(r)) {
        count += r + 1;
        l--;
      } else {
        r--;
      }
    }
    return count;
  }

  void calculate(int bit, int last, int depth) {
    if (depth == N / 2) {
      int count = calculateRate(bit);
      if (count > maxCount) {
        max = bit;
        maxCount = count;
      }
      return;
    }

    for (int i = last + 1; i < N; i++) {
      calculate(bit | (1 << i), i, depth + 1);
    }
  }
}