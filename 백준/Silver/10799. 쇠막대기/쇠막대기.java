import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int result;
  String input;

  void init() throws IOException {
    result = 0;
    input = br.readLine();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result);

    System.out.println(sb);

    br.close();
  }

  void solution() {
    Stack<Character> stack = new Stack<>();
    stack.push(input.charAt(0));
    for (int i = 1; i < input.length(); i++) {
      char before = input.charAt(i - 1);
      char current = input.charAt(i);
      if (!stack.isEmpty() && stack.peek() == '(' && current == ')') {
        stack.pop();
        if (before == '(') result += stack.size();
        else result++;
      } else {
        stack.push(current);
      }
    }
  }
}