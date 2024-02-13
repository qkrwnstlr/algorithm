import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	BufferedReader br;
	StringBuilder sb;
	int N, count;
	int[] dx = { -2, -1, 1, 2 };
	int[] arr;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			count = 0;

			for (int i = 2; i < N - 2; i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < dx.length; j++) {
					int x = i + dx[j];
					temp = Math.min(temp, arr[i] - arr[x]);
				}
				if (temp > 0) {
					count += temp;
				}
			}

			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
