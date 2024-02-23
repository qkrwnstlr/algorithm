import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, K, result, max;
	int[][] table;
	Node[][] graph;
	List<Node> top;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			table = new int[N][N];
			graph = new Node[N][N];
			top = new ArrayList<>();
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
					graph[i][j] = new Node(i, j);
					if (table[i][j] > max) {
						max = Math.max(max, table[i][j]);
						top.clear();
					}
					if (table[i][j] == max) {
						top.add(graph[i][j]);
					}
				}
			}

			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (top.size() == 1 && table[i][j] == max) {
						continue;
					}
					for (int k = 0; k <= K; k++) {
						table[i][j] -= k;
						calculate();
						table[i][j] += k;
					}
				}
			}

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	void calculate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j].clear();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < dx.length; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (isExist(nx, ny)) {
						if (table[i][j] < table[nx][ny]) {
							graph[i][j].addChild(graph[nx][ny]);
						}
					}
				}
			}
		}

		for (int i = 0; i < top.size(); i++) {
			result = Math.max(result, top.get(i).length);
		}
	}

	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { -1, 0, 1, 0 };

	boolean isExist(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Node {
	int x, y, length;
	List<Node> child;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.length = 1;
		this.child = new ArrayList<>();
	}

	void setLength(int length) {
		if (length > this.length) {
			this.length = length;
			for (int i = 0; i < child.size(); i++) {
				child.get(i).setLength(length + 1);
			}
		}
	}

	void clear() {
		length = 1;
		child.clear();
	}

	void addChild(Node node) {
		child.add(node);
		node.setLength(this.length + 1);
	}
}
