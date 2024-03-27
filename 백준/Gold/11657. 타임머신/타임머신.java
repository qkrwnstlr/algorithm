import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	int N, M;
	boolean isPossible;
	long[] dist;
	Node[] graph;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new long[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		graph = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			graph[i] = new Node(u, v, w);
		}
	}

	void run() throws IOException {
		init();
		solution();
		StringBuffer sb = new StringBuffer();
		if (isPossible) for (int i = 1; i < N; i++) sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]).append("\n");
		else sb.append(-1);
		System.out.println(sb);
	}

	void solution() {
		dist[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Node node = graph[j];
				if (dist[node.u] == Integer.MAX_VALUE) continue;
				if (dist[node.v] > dist[node.u] + node.w) {
					dist[node.v] = dist[node.u] + node.w;
				}
			}
		}
		for (int j = 0; j < M; j++) {
			Node node = graph[j];
			if (dist[node.u] == Integer.MAX_VALUE) continue;
			if (dist[node.v] > dist[node.u] + node.w) {
				return;
			}
		}
		isPossible = true;
	}
}

class Node {
	int u, v, w;

	Node(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}