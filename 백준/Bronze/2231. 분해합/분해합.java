import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int i = 1; i <= N; i++) {
      if(i + Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum() == N) {
        System.out.println(i);
        return;
      }
    }
    System.out.println(0);
  }
}