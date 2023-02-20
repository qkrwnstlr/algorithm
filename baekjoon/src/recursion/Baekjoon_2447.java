package recursion;

import java.io.*;

public class Baekjoon_2447 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int k = 0;
  static int n = 0;

  static void write() throws IOException {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { // 출력할 그림을 2차원 배열이라 생각
        if (isStar(decimalToTrinary(i), decimalToTrinary(j))) { // 출력할 index를 3진수로 바꿔 *을 찍을지 공백을 찍을지 선택
          bw.write("*");
        } else {
          bw.write(" ");
        }
      }
      bw.write("\n"); // 한줄 끝나면 줄 바꿈
    }
  }

  static int[] decimalToTrinary(int idx) { // 10진수를 3진수로 바꿈
    int[] trinary = new int[k];
    int current = idx;
    for (int i = 0; i < k; i++) {
      trinary[i] = current % 3;
      current = current / 3;
    }
    return trinary;
  }

  static boolean isStar(int[] x, int[] y) {
    for (int i = 0; i < k; i++) {
      if (x[i] == 1 && y[i] == 1) return false; // (1xx, 1xx), (x1x, x1x), (xx1, xx1) ... 일때 공백을 출력함
    }
    return true;
  }

  static void result() throws IOException {
    String str = br.readLine();
    n = Integer.parseInt(str);
    for (k = 1; Math.pow(3, k) < n; k++) continue;
    write();
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
