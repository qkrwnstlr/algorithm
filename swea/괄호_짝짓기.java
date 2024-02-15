import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	BufferedReader br;
	StringBuilder sb;
	StringTokenizer st;

	int N;
	long result;

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());

			result = check(br.readLine()) ? 1 : 0;

			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	boolean check(String s) {
		int[] stack = new int[N];
		int top = -1;

		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
			case '[':
			case '{':
			case '<':
				stack[++top] = parse(c);
				break;
			case ')':
			case ']':
			case '}':
			case '>':
				if (top == -1 || stack[top] != parse(c)) {
					return false;
				} else {
					top--;
				}
			}
		}

		return top == -1;
	}

	int parse(char s) {
		switch (s) {
		case '(':
		case ')':
			return 0;
		case '[':
		case ']':
			return 1;
		case '{':
		case '}':
			return 2;
		case '<':
		case '>':
			return 3;
		default:
			return -1;
		}
	}
}
