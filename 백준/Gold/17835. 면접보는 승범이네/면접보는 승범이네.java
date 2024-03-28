import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	int N, M, K;
	int[] interview;
	List<Map<Integer, Long>> graph;
	long[] result;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = new long[2];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) graph.add(new HashMap<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()) - 1;
			int u = Integer.parseInt(st.nextToken()) - 1;
			long w = Integer.parseInt(st.nextToken());
			try {
				graph.get(u).put(v, Math.min(graph.get(u).get(v), w));
			} catch (Exception e) {
				graph.get(u).put(v, w);
			}
		}

		interview = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i) - 1).toArray();
	}

	void run() throws IOException {
		init();
		solution();
		Arrays.stream(result).forEach(System.out::println);
	}

	void solution() {
		Queue<Edge> q = new PriorityQueue<>();

		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);

		boolean[] visited = new boolean[N];

		for (int i = 0; i < K; i++) {
			dist[interview[i]] = 0;
			q.add(new Edge(interview[i], 0));
		}

		while (!q.isEmpty()) {
			Edge e = q.poll();
			int u = e.v;
			if (visited[u]) continue;
			visited[u] = true;
			graph.get(u).keySet().forEach((v) -> {
				if (visited[v] || dist[v] <= dist[u] + graph.get(u).get(v)) return;
				dist[v] = dist[u] + graph.get(u).get(v);
				q.add(new Edge(v, dist[v]));
			});
		}

		for (int i = 0; i < N; i++) {
			if (result[1] < dist[i]) {
				result[0] = i + 1;
				result[1] = dist[i];
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int v;
	long w;

	Edge(int v, long w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w < 0 ? -1 : 1;
	}
}
