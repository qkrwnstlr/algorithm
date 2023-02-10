package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14502 {
  static int maxSafeArea = 0;
  static int[][] laboratory;

  static void setVirus(int[][] tempLaboratory, int i, int j) {
    int n = tempLaboratory.length;
    int m = tempLaboratory[0].length;
    if (tempLaboratory[i][j] == 2) {
      if (j - 1 >= 0 && tempLaboratory[i][j - 1] == 0) {
        tempLaboratory[i][j - 1] = 2;
        setVirus(tempLaboratory, i, j - 1);
      }
      if (j + 1 < m && tempLaboratory[i][j + 1] == 0) {
        tempLaboratory[i][j + 1] = 2;
        setVirus(tempLaboratory, i, j + 1);
      }
      if (i - 1 >= 0 && tempLaboratory[i - 1][j] == 0) {
        tempLaboratory[i - 1][j] = 2;
        setVirus(tempLaboratory, i - 1, j);
      }
      if (i + 1 < n && tempLaboratory[i + 1][j] == 0) {
        tempLaboratory[i + 1][j] = 2;
        setVirus(tempLaboratory, i + 1, j);
      }
    }
  }

  static void checkSafeArea(int[][] tempLaboratory) {
    int n = tempLaboratory.length;
    int m = tempLaboratory[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        setVirus(tempLaboratory, i, j);
      }
    }
    int tempSafeArea = 0;
    for (int[] ints : tempLaboratory) {
      for (int state : ints) {
        if (state == 0) tempSafeArea++;
      }
    }

    maxSafeArea = Math.max(maxSafeArea, tempSafeArea);
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    laboratory = new int[n][m];

    for (int i = 0; i < n; i++) { // 초기 입력값 설정
      str = br.readLine();
      st = new StringTokenizer(str);
      for (int j = 0; j < m; j++) {
        laboratory[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int a = 0; a < n; a++) {
      for (int b = 0; b < m; b++) {
        if (laboratory[a][b] != 0) continue;
        for (int c = 0; c < n; c++) {
          for (int d = 0; d < m; d++) {
            if (laboratory[c][d] != 0 || (a == c && b == d)) continue;
            for (int e = 0; e < n; e++) {
              for (int f = 0; f < m; f++) {
                if (laboratory[e][f] != 0 || (a == e && b == f) || (c == e && d == f)) continue;
                int[][] tempLaboratory = new int[n][m];
                for (int i = 0; i < n; i++) {
                  System.arraycopy(laboratory[i], 0, tempLaboratory[i], 0, m);
                }
                tempLaboratory[a][b] = 1;
                tempLaboratory[c][d] = 1;
                tempLaboratory[e][f] = 1;
                checkSafeArea(tempLaboratory);
              }
            }
          }
        }
      }
    }

    System.out.println(maxSafeArea);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
