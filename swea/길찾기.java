import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

  BufferedReader br;
	StringBuilder sb;
	StringTokenizer st;

	int N;
	long result;

	int[][] load;
	boolean[] visited;

	Stack<Integer> stack;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			load = new int[100][2];
			visited = new boolean[100];
			for (int i = 0; i < 100; i++) {
				Arrays.fill(load[i], -1);
			}

			st = new StringTokenizer(br.readLine());
			testCase = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (load[start][0] == -1) {
					load[start][0] = end;
				} else {
					load[start][1] = end;
				}
			}
			
			result = dfs();

			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	int dfs() {
		stack = new Stack<>();
		visit(0);

		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (current == 99) {
				return 1;
			}
			for (int i = 0; i < 2; i++) {
				if (load[current][i] != -1) {
					visit(load[current][i]);
				}
			}
		}
		return 0;
	}

	void visit(int index) {
		if (!visited[index]) {
			stack.push(index);
			visited[index] = true;
		}
	}
}
