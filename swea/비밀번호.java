import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			sb.append("#").append(testCase);
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			Stack stack = new Stack(N);
			for (int i = 0; i < N; i++) {
				char c = s.charAt(i);
				if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			sb.append(" ").append(stack).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}

class Stack {
	char[] arr;
	int top;

	Stack(int size) {
		arr = new char[size];
		top = -1;
	}

	void push(char data) {
		arr[++top] = data;
	}

	char pop() {
		return arr[top--];
	}

	char peek() {
		return arr[top];
	}

	boolean isEmpty() {
		return top == -1;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i <= top; i++) {
			s += arr[i];
		}
		return s;
	}
}
