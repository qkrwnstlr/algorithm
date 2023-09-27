import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < N; i++) stack.push(Integer.parseInt(br.readLine()));

    int count = 0;

    for(int i = 0; i < N; i++) {
      int k = stack.pop();
      count += K / k;
      K %= k;
    }

    System.out.println(count);
  }
}