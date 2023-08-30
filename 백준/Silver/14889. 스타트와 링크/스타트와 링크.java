import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] matrix;

  static ArrayList<Integer> A = new ArrayList<>();
  static ArrayList<Integer> B = new ArrayList<>();
  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    split(0);

    System.out.println(result);
  }

  static void split(int depth) {
    if (depth == N) {
      int a = 0;
      int b = 0;
      for (int i : A) for (int j : A) a += matrix[i][j];
      for (int i : B) for (int j : B) b += matrix[i][j];
      result = Math.min(result, Math.abs(a - b));
    }

    if (A.size() != N / 2) {
      A.add(depth);
      split(depth + 1);
      A.remove(A.size() - 1);
    }

    if (B.size() != N / 2) {
      if (B.size() != N / 2) B.add(depth);
      split(depth + 1);
      B.remove(B.size() - 1);
    }
  }
}