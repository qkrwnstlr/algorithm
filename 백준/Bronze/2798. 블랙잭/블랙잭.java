import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] card = new int[N];
    int answer = 0;
    for (int i = 0; i < N; i++) card[i] = sc.nextInt();
    for (int i = 0; i < N - 2; i++)
      for (int j = i + 1; j < N - 1; j++)
        for (int k = j + 1; k < N; k++) {
          int temp = card[i] + card[j] + card[k];
          if(temp <= M) answer = Math.max(answer, temp);
        }
    System.out.println(answer);
  }
}