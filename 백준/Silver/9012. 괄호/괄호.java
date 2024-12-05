import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N;
  String input, result;

  void init() throws IOException {
    input = br.readLine();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      init();
      solution();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() {
    Stack<String> stack = new Stack<>();
    Arrays.stream(input.split("")).forEach(it -> {
      if (!stack.isEmpty() && stack.peek().equals("(") && it.equals(")")) {
        stack.pop();
      } else {
        stack.push(it);
      }
    });
    result = stack.isEmpty() ? "YES" : "NO";
  }
}