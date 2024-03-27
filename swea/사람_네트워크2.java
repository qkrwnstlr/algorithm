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
	int[][] graph, dist;

	void init() throws IOException {
		result = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		for (int r = 0; r < N; r++) {
			Arrays.fill(graph[r], 100000000);
			graph[r][r] = 0;
			for (int c = 0; c < N; c++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) graph[r][c] = value;
			}
		}
		dist = new int[N][N];
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
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		for (int r = 0; r < N; r++) result = Math.min(result, Arrays.stream(graph[r]).sum());
	}
}
