import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    boolean[] isBroken = new boolean[10];
    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) isBroken[Integer.parseInt(st.nextToken())] = true;
    }
    int result = Math.abs(N - 100);

    for (int i = 0; i <= 999999; i++) {
      String[] temp = String.valueOf(i).split("");
      int j;
      for (j = 0; j < temp.length; j++) if (isBroken[Integer.parseInt(temp[j])]) break;
      if (j == temp.length) result = Math.min(Math.abs(N - i) + temp.length, result);
    }

    System.out.println(result);
  }
}