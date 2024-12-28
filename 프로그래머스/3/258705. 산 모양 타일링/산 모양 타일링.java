class Solution {
  public static void main(String[] args) {
    int n = 10;
    int[] tops = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    System.out.println(new Solution().solution(n, tops));
  }

  public int solution(int n, int[] tops) {
    int[] a = new int[n];
    int[] b = new int[n];

    a[0] = 2 + tops[0];
    b[0] = 1;

    for (int i = 1; i < n; i++) {
      a[i] = ((2 + tops[i]) * a[i - 1] % 10007 + (1 + tops[i]) * b[i - 1] % 10007) % 10007;
      b[i] = (a[i - 1] % 10007 + b[i - 1] % 10007) % 10007;
    }

    return (a[n - 1] + b[n - 1]) % 10007;
  }
}