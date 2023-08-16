import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] answerList = new int[N][3];
    int result = 0;
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        answerList[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        if (i == j) continue;
        for (int k = 1; k < 10; k++) {
          if (i == k || j == k) continue;
          if (check(i * 100 + j * 10 + k, answerList)) result++;
        }
      }
    }
    System.out.println(result);
  }

  static boolean check(int number, int[][] answerList) {
    String numberS = String.valueOf(number);
    for (int[] answer : answerList) {
      String answerS = String.valueOf(answer[0]);
      int strike = 0;
      int ball = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (numberS.charAt(i) == answerS.charAt(j)) {
            if (i == j) strike++;
            else ball++;
          }
        }
      }
      if (strike != answer[1] || ball != answer[2]) return false;
    }
    return true;
  }
}