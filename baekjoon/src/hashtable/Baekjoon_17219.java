package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon_17219 {
  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    StringBuilder sb = new StringBuilder();

    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, String> hashTable = new HashMap<>(n);

    for (var i = 0; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      hashTable.put(st.nextToken(), st.nextToken());
    }
    for (var i = 0; i < m; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      sb.append(hashTable.get(st.nextToken())).append("\n");
    }
    System.out.println(sb);
  }
  public static void main(String[] args) throws Exception {
    result();
  }
}
