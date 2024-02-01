import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int test_case = 1; test_case <= T; test_case++) {
      int N = Integer.parseInt(br.readLine()), current = 0, check = 0;
      while (check != (1 << 10) - 1) {
        int temp = (current += N) * 10;
        while ((temp /= 10) != 0) check |= 1 << (temp % 10);
      }
      System.out.printf("#%d %d\n", test_case, current);
    }
    br.close();
  }

  public static void main(String[] args) throws IOException {
    new Solution().result();
  }
}