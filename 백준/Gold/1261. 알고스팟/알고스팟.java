import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	int N, M, result;
	int[] map, dist;
	boolean[] visited;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M * N];
		for (int r = 0; r < M; r++) {
			String line = br.readLine();
			for (int c = 0; c < N; c++) map[r * N + c] = line.charAt(c) - '0';
		}
		dist = new int[M * N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[M * N];
	}

	void run() throws IOException {
		init();
		solution();
		System.out.println(result);
	}

	void solution() {
		Queue<Edge> q = new PriorityQueue<>();
		dist[0] = 0;
		q.add(new Edge(0, 0));

		while (!q.isEmpty()) {
			Edge e = q.poll();
			if (visited[e.v]) continue;
			visited[e.v] = true;
			int r = e.v / N, c = e.v % N;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i], ni = nr * N + nc;
				if (!isExist(nr, nc) || visited[ni] || dist[ni] <= dist[e.v] + map[ni]) continue;
				dist[ni] = dist[e.v] + map[ni];
				q.add(new Edge(ni, dist[ni]));
			}
		}

		result = dist[M * N - 1];
	}

	int[] dr = { 0, 1, 0, -1 }, dc = { -1, 0, 1, 0 };

	boolean isExist(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
}

class Edge implements Comparable<Edge> {
	int v, w;

	Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}