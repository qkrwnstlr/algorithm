import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	BufferedReader br;
	StringBuilder sb;
	int N, result;
	int[] count;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = 1000;
			test_case = Integer.parseInt(br.readLine());
			count = new int[101];
			Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach((e) -> {
				count[e]++;
			});

			for (int i = 0; i <= 100; i++) {
				if (count[result] <= count[i]) {
					result = i;
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
