import java.io.*;

public class Main {
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] read = sc.readLine().split(" ");
    N = Integer.parseInt(read[0]);
    M = Integer.parseInt(read[1]);
    String[] boarder = new String[N * M];
    for(int i = 0; i < N; i++) {
      read = sc.readLine().split("");
      for(int j = 0; j < M; j++) boarder[i * M + j] = read[j];
    }
    int result = Integer.MAX_VALUE;
    for(int i = 0; i <= N - 8; i++) {
      for(int j = 0; j <= M - 8; j++) {
        int temp = Math.min(count(boarder, "W", "B", i, j), count(boarder, "B", "W", i, j));
        result = Math.min(result, temp);
      }
    }
    System.out.println(result);
  }

  static int count(String[] boarder, String first, String next, int startX, int startY) {
    int result = 0;
    for(int i = startX; i < startX + 8; i++) for(int j = startY; j < startY + 8; j++) {
      if((i + j) % 2 == 0 && !boarder[M * i + j].equals(first)) result++;
      if((i + j) % 2 == 1 && !boarder[M * i + j].equals(next)) result++;
    }
    return result;
  }
}