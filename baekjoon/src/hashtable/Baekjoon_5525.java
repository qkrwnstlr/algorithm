package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon_5525 {
  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine(); // 한줄씩 받기
    int n = Integer.parseInt(str);
    str = br.readLine(); // 한줄씩 받기
    int m = Integer.parseInt(str);
    str = br.readLine();

    ArrayList<Integer> lengthList = new ArrayList<>();
    int temp = 0;

    for (int i = 0; i < m; i++) {
      char c = str.charAt(i);
      if ((temp % 2 == 1 && c == 'O') || (temp % 2 == 0 && c == 'I')) {
        temp++;
        if (i != m - 1) continue;
      }
      if (temp / 2 != 0) lengthList.add(temp / 2 + 1);
      if (c == 'I') temp = 1;
      else temp = 0;
    }

    int length = 0;
    for (Integer integer : lengthList) {
      if (integer - n > 0) length += integer - n;
    }
    System.out.println(length);
  }

  public static void main(String[] args) throws Exception {
    result();
  }
}