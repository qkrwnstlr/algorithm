package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1000 {
  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기

    System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_1000().result();
  }
}

