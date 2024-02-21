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

	int N, result;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			N = Integer.parseInt(br.readLine());

			result = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens() <= 2) {
					String value = st.nextToken();
					value = st.nextToken();
					switch (value) {
					case "+":
					case "-":
					case "*":
					case "/":
						result = 0;
					}
				} else {
					String value = st.nextToken();
					value = st.nextToken();
					switch (value) {
					case "+":
					case "-":
					case "*":
					case "/":
						break;
					default:
						result = 0;
					}
				}
			}

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}
