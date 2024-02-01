import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
  public void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int test_case = 1; test_case <= T; test_case++) {
      int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int n = temp[0];
      int m = temp[1];

      if((m & ((1 << n) - 1)) == ((1 << n) - 1)) System.out.printf("#%d ON\n", test_case);
      else System.out.printf("#%d OFF\n", test_case);
    }
  }

  public static void main(String[] args) throws IOException {
    new Solution().result();
  }
}