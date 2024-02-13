import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	BufferedReader br;
	StringBuilder sb;
	int N, dump, min, max;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };
	int[] arr, count;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = 100;
			count = new int[N + 1];
			dump = Integer.parseInt(br.readLine());
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			Arrays.stream(arr).forEach((e) -> count[e]++);

			for (int i = 1; i <= N; i++) {
				if (count[i] != 0) {
					min = i;
					break;
				}
			}

			for (int i = N; i > 0; i--) {
				if (count[i] != 0) {
					max = i;
					break;
				}
			}

			for (int i = 0; i < dump; i++) {
				count[min]--;
				count[min + 1]++;
				count[max]--;
				count[max - 1]++;

				if (count[min] == 0) {
					min++;
				}
				if (count[max] == 0) {
					max--;
				}
				
				if(max - min <= 1) {
					break;
				}
			}

			sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
