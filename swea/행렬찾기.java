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
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			init();
			solution();
			sb.append("#").append(testCase).append(" ").append(result).append(" ");
			for (int i = 0; i < result * 2; i += 2) sb.append(matrix[i]).append(" ").append(matrix[i + 1]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	void solution() {
		parseTable();
		parseMatrix();
		result = matrix.length / 2;
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
		int[] key = matrixMap.keySet().stream().sorted((i1, i2) -> {
			if (i1 * matrixMap.get(i1) - i2 * i2 * matrixMap.get(i2) != 0) {
				return i1 * matrixMap.get(i1) - i2 * matrixMap.get(i2);
			}
			return i1 - i2;
		}).mapToInt(Integer::intValue).toArray();

		matrix = new int[key.length * 2];
		for (int i = 0; i < key.length * 2; i += 2) {
			matrix[i] = key[i / 2];
			matrix[i + 1] = matrixMap.get(matrix[i]);
		}
	}
}
