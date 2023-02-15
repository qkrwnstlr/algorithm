package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1016 {
  static boolean[] isSquare;

  static ArrayList<Long> nonSquareList = new ArrayList<>();

  static boolean checkIsSquare(long n) {
    // n이 제곱 ㄴㄴ수인지 판단
    for (long i = 2; i * i <= n; i++) {
      if (n % (i * i) == 0) return true;
    }
    return false;
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    long min = Integer.parseInt(st.nextToken());
    long max = Integer.parseInt(st.nextToken());
    isSquare = new boolean[(int) (max - min + 2)];
    Arrays.fill(isSquare, true);

    for (int i = 0; i <= max - min; i++) {
      if (!isSquare[i]) continue;
      if (!checkIsSquare(i + min)) {
        nonSquareList.add(i + min);
        continue;
      }
      for (long j = (i + min) * 2; j <= max; j += (i + min)) {
        isSquare[(int) (j - min)] = false;
      }
    }
    System.out.println(nonSquareList.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
