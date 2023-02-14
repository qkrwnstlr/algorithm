package math;

import java.io.*;
import java.util.ArrayList;

public class Baekjoon_6588 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static ArrayList<Integer> cash = new ArrayList<>();

  static boolean isPrime(int n) {
    for (int i = 2; i * i < n; i++) if (n % i == 0) return false; // 나누어 떨어지면 false
    return true; // 아무것도 나누어 떨어지지 않으면 true
  }

  static void findPrime() {
    for (int i = 2; i < 100000; i++) if (isPrime(i)) cash.add(i); // 2부터 10만까지 모든 소수를 구함
  }

  static int goldBach(int n) {
    for (int i : cash) 
      for (int j = cash.size() - 1; j >= 0; j--)
        if (cash.get(j) == n - i) return i; // 입력받은 값을 소수에서 뺏을때 그 수가 소수인지 확인
    return 0; // 끝까지 없으면 0 반환
  }

  static void write(int n, int a) throws IOException {
    if (a == 0) {
      bw.write("Goldbach's conjecture is wrong.\n");
      return;
    }
    bw.write(String.valueOf(n));
    bw.write(" = ");
    bw.write(String.valueOf(a));
    bw.write(" + ");
    bw.write(String.valueOf(n - a));
    bw.write("\n");
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    findPrime();
    while (true) {
      String str = br.readLine();
      int n = Integer.parseInt(str);
      if (n == 0) break;
      write(n, goldBach(n));
    }
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
