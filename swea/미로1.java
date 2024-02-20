import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, start, end, result;
	int[][] table;
	boolean visited[];
	Queue<Integer> queue;

	int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(br.readLine());

			N = 16;
			table = new int[N][N];
			visited = new boolean[N * N];

			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(temp[j]);
					if (table[i][j] == 2) {
						start = i * N + j;
					} else if (table[i][j] == 3) {
						end = i * N + j;
					}
				}
			}

			result = 0;

			queue = new LinkedList<>();
			queue.add(start);
			visited[start] = true;

			while (!queue.isEmpty()) {
				int current = queue.poll();
				int x = current / N, y = current % N;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i], ny = y + dy[i];
					int next = nx * N + ny;
					if (isExist(nx, ny) && table[nx][ny] != 1 && !visited[next]) {
						if (table[nx][ny] == 3) {
							result = 1;
							break;
						}
						queue.add(next);
						visited[next] = true;
					}
				}
			}

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	boolean isExist(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
