import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int current = Math.min(N, 3);
    int before = 2;
    for (int i = 3; i < N; i++) {
      int temp = current;
      current = (before + current) % 15746;
      before = temp;
    }
    System.out.println(current);
  }
}