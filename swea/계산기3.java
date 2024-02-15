import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			sb.append("#").append(testCase);

			String formula = makePostFix(br.readLine());

			sb.append(" ").append(calculate(formula)).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	String makePostFix(String formula) {
		String postFix = "";
		Stack<Character> operator = new Stack<>();
		for (int i = 0; i < formula.length(); i++) {
			char c = formula.charAt(i);
			switch (c) {
			case '+': {
				while (!operator.isEmpty() && operator.peek() == '*') {
					postFix += operator.pop();
				}
				operator.push(c);
				break;
			}
			case '*': {
				if (formula.charAt(i + 1) == '(') {
					operator.push(c);
				} else {
					postFix += formula.charAt(++i);
					postFix += c;
				}
				break;
			}
			case '(': {
				operator.push(c);
				break;
			}
			case ')': {
				while (!operator.isEmpty()) {
					if (operator.peek() == '(') {
						operator.pop();
						break;
					}
					postFix += operator.pop();
				}
				break;
			}
			default:
				postFix += c;
			}
		}

		while (!operator.isEmpty()) {
			postFix += operator.pop();
		}

		return postFix;
	}

	int calculate(String formula) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < formula.length(); i++) {
			char c = formula.charAt(i);
			switch (c) {
			case '+': {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n1 + n2);
				break;
			}
			case '*': {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n1 * n2);
				break;
			}
			default:
				stack.push(c - '0');
			}
		}

		return stack.pop();
	}
}
