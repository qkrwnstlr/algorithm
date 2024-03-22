import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, result;
	int[] table;
	boolean[] visited;
	PriorityQueue<Node> pq;

	void init() throws IOException {
		result = -1;
		N = Integer.parseInt(br.readLine());
		table = new int[N * N];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) table[r * N + c] = line.charAt(c) - '0';
		}
		visited = new boolean[N * N];
		pq = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
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

	int[] dr = { 0, 1, 0, -1 }, dc = { -1, 0, 1, 0 };

	void solution() {
		visited[0] = true;
		pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			int r = n.i / N, c = n.i % N;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d], ni = nr * N + nc;
				if (!isExist(nr, nc) || visited[ni]) continue;

				if (ni == N * N - 1) {
					result = n.value + table[ni];
					return;
				}

				visited[ni] = true;
				pq.add(new Node(ni, n.value + table[ni]));
			}
		}
	}

	boolean isExist(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

class Node {
	int i, value;

	Node(int id, int value) {
		this.i = id;
		this.value = value;
	}
}
