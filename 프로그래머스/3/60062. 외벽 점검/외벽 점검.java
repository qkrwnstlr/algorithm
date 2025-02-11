class Solution {
  public int solution(int n, int[] weak, int[] dist) {
    init(n, weak, dist);
    dfs(0, new int[dist.length], 0);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  int n, w, result;
  int[] weak, dist;

  void init(int n, int[] weak, int[] dist) {
    result = Integer.MAX_VALUE;
    this.n = n;
    this.w = weak.length;
    this.dist = dist;
    this.weak = new int[weak.length * 2];
    for (int i = 0; i < weak.length; i++) this.weak[i] = weak[i];
    for (int i = weak.length; i < weak.length * 2; i++) this.weak[i] = n + weak[i - weak.length];
  }

  void dfs(int checked, int[] permutation, int depth) {
    if (depth == dist.length) {
      result = Math.min(result, check(permutation));
      return;
    }

    for (int i = 0; i < dist.length; i++) {
      if ((checked & (1 << i)) == 0) {
        permutation[depth] = i;
        dfs(checked | (1 << i), permutation, depth + 1);
      }
    }
  }

  int check(int[] permutation) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < w; i++) result = Math.min(result, check(i, permutation));
    return result;
  }

  int check(int start, int[] permutation) {
    int count = 0;
    int current = start;
    while (current < start + w && count < dist.length) {
      int next = current + 1;
      while (next < start + w && dist[permutation[count]] >= weak[next] - weak[current]) {
        next++;
      }
      current = next;
      count++;
    }
    if (current == start + w) return count;
    return Integer.MAX_VALUE;
  }
}