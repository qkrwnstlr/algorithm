package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon_1920 {
  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기
    int n = Integer.parseInt(st.nextToken());

    HashMap<Integer, Boolean> hashTable = new HashMap<>(n);

    str = br.readLine();
    st = new StringTokenizer(str);
    for (var i = 0; i < n; i++) {
      hashTable.put(Integer.parseInt(st.nextToken()), true);
    }

    str = br.readLine(); // 한줄씩 받기
    st = new StringTokenizer(str); // " "를 기준으로 나눈기
    int m = Integer.parseInt(st.nextToken());

    str = br.readLine();
    st = new StringTokenizer(str);
    for (var i = 0; i < m; i++) {
      if (hashTable.get(Integer.parseInt(st.nextToken())) != null)
        sb.append(1).append("\n");
      else sb.append(0).append("\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    result();
  }
}
