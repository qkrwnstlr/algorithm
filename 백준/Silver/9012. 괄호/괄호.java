import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder result;
  int N;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
  }

  void solution() throws IOException {
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      ArrayDeque<Character> stack = new ArrayDeque<>();
      for (int j = 0; j < input.length(); j++) {
        if (input.charAt(j) == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
        else stack.push(input.charAt(j));
      }
      result.append(stack.isEmpty() ? "YES" : "NO").append("\n");
    }
  }
}
