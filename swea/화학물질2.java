import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
	Map<Integer, Integer> matrixMap;
	int[] matrix;

	void init() throws IOException {
		result = 0;
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for (int r = 0; r < N; r++) {
			table[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		parseTable();
		parseMatrix();
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
		int[][] dp = new int[matrixMap.size()][matrixMap.size()];
		for (int i = 1; i < matrixMap.size(); i++) {
			for (int j = 0; j < matrixMap.size() - i; j++) {
				int r = j, c = j + i;
				dp[r][c] = Integer.MAX_VALUE;
				for (int k = 0; k < i; k++) {
					int lr = r, lc = c - (i - k), dr = r + k + 1, dc = c;
					dp[r][c] = Math.min(dp[r][c], dp[lr][lc] + dp[dr][dc] + matrix[lr] * matrix[dr] * matrix[dc + 1]);
				}
			}
		}
		result = dp[0][dp.length - 1];
	}

	void parseTable() {
		matrixMap = new HashMap<>();
		boolean[][] visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c] || table[r][c] == 0) continue;
				int er = r, ec = c;
				while (ec < N && table[r][ec] != 0) ec++;
				while (er < N && table[er][c] != 0) er++;
				for (int i = r; i < er; i++) {
					for (int j = c; j < ec; j++) visited[i][j] = true;
				}
				matrixMap.put(er - r, ec - c);
			}
		}
	}

	void parseMatrix() {
		matrix = new int[matrixMap.size() + 1];
		matrix[0] = matrixMap.keySet().stream().filter((key) -> !matrixMap.values().contains(key)).findFirst().get();
		for (int i = 1; i < matrixMap.size() + 1; i++) matrix[i] = matrixMap.get(matrix[i - 1]);
	}
}
