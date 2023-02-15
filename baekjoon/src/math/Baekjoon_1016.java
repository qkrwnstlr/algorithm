package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1016 {
  static long min;
  static long max;
  static boolean[] isSquare;
  static boolean[] isPrime;
  static ArrayList<Long> squareList = new ArrayList<>();
  static ArrayList<Integer> primeList = new ArrayList<>();
  static boolean[] isChecked;

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
    isChecked = new boolean[primeList.size()];
    Arrays.fill(isChecked, false);
    for (int i = 0; i < max - min + 1; i++) {
      if (isSquare[i]) continue;
      for (int p = 0; p < primeList.size(); p++) {
        if(isChecked[p]) continue; // 이미 체크한 소수는 넘어감
        int j = primeList.get(p); // 앞으로 체크할 소수
        if ((long) j * j > i + min) break; // 만약 소수의 제곱이 나머지를 확인할 값보다 크면 절데 0이 아니므로 넘어감
        if ((i + min) % ((long) j * j) == 0) { // 만약 제곱수로 나누어 떨어지면(제곰 ㄴㄴ수가 아니라면)
          isChecked[p] = true; // 해당 소수의 제곱에 걸리는 수는 이미 모두 체크함을 알림
          for (long k = i + min; k <= max; k += (long) j * j) { // 해당 수와 같은 소수의 제곱으로 나누어 떨어지는 모든 값을 제곱수가 아니라고 판단함
            int index = (int) (k - min);
            if(isSquare[index]) continue; // 36 같이 4에도 걸리고 9에도 걸리는 값이 중복되는 것을 막음
            squareList.add(k);
            isSquare[index] = true; // 제곱수로 나누어 떨어짐을 저장
          }
          break;
        }
      }
    }
    System.out.println(max - min + 1 - squareList.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
