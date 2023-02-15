package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_1016 {
  static long min;
  static long max;
  static boolean[] isSquare;
  static boolean[] isPrime;
  static HashSet<Long> squareSet = new HashSet<>();
  static ArrayList<Integer> primeList = new ArrayList<>();

  static void eratosthenes() {
    int sqrtMax = (int) Math.sqrt(max);
    for (int i = 2; i <= sqrtMax; i++) {
      if (!isPrime[i]) continue;
      primeList.add(i);
      for (int j = i * 2; j <= sqrtMax; j += i) {
        if (isPrime[j]) isPrime[j] = false;
      }
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    min = Long.parseLong(st.nextToken());
    max = Long.parseLong(st.nextToken());
    isSquare = new boolean[(int) (max - min + 1)];
    isPrime = new boolean[(int) Math.sqrt(max) + 1];
    Arrays.fill(isSquare, false);
    Arrays.fill(isPrime, true);
    eratosthenes(); // 소수만 고름

    for (int i : primeList) { // 소수들에 대해서
      long square = (long) i * i;
      for (long j = (min / square) * square; j <= max; j += square) { // 소수의 제곱의 배수가
        if (j >= min) squareSet.add(j); // min과 max사이면 제곱 ㄴㄴ수가 아니다.
      }
    }

    System.out.println(max - min + 1 - squareSet.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
