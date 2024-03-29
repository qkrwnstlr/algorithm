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

	int N, M, K, result;
	int[][] table;

	void init() throws IOException {
		result = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		for (int r = 0; r < N; r++) {
			table[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
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
		DFS(0, 0);
	}

	void DFS(int depth, int count) {
		if (depth == N) {
			cLoop: for (int c = 0; c < M; c++) {
				int r = 0, current = table[r][c], temp = 0;
				for (; r < N; r++) {
					if (current == table[r][c]) {
						if (++temp == K) continue cLoop;
					} else {
						current = table[r][c];
						temp = 1;
					}
				}
				return;
			}
			result = Math.min(result, count);
			return;
		}

		int[] temp = Arrays.copyOf(table[depth], M);
		DFS(depth + 1, count);
		Arrays.fill(table[depth], 0);
		DFS(depth + 1, count + 1);
		Arrays.fill(table[depth], 1);
		DFS(depth + 1, count + 1);
		table[depth] = temp;
	}
}
