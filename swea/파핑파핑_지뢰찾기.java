import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	BufferedReader br;
	StringBuilder sb;

	int N, result;
	int[][] table;
	int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					if (temp[j].equals("*")) {
						table[i][j] = -1;
						for (int k = 0; k < dx.length; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (isExist(nx, ny) && table[nx][ny] != -1) {
								table[nx][ny]++;
							}
						}
					}
				}
			}

			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 0) {
						result++;
						click(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] != -1) {
						result++;
						click(i, j);
					}
				}
			}

			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	void click(int x, int y) {
		if (table[x][y] != 0) {
			table[x][y] = -1;
			return;
		}
		table[x][y] = -1;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isExist(nx, ny)) {
				click(nx, ny);
			}
		}
	}

	boolean isExist(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
