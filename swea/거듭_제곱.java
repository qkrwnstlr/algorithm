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
			testCase = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			result = pow(a, b);

			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	int pow(int a, int b) {
		if (b == 0) {
			return 1;
		}
		return a * pow(a, b - 1);
	}
}
