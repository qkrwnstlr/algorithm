import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, result;
	int[][] table;
	boolean[] visited;

	void init() throws IOException {
		result = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for (int r = 0; r < N; r++) {
			table[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		visited = new boolean[N];
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			init();
			solution();
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	void solution() {
		comb(0, 0);
	}

	void comb(int depth, int start) {
		if (depth == N / 2) {
			int a = 0, b = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r] && visited[c]) a += table[r][c];
					if (!visited[r] && !visited[c]) b += table[r][c];
				}
			}
			result = Math.min(result, Math.abs(a - b));
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(depth + 1, i + 1);
			visited[i] = false;
		}
	}
}
