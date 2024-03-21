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

	int N;
	long[] arrX, arrY;
	long result;
	double E;
	boolean[] visited;
	PriorityQueue<Edge> pq;

	void init() throws IOException {
		result = 0;
		N = Integer.parseInt(br.readLine());
		arrX = new long[N];
		arrY = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arrX[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arrY[i] = Long.parseLong(st.nextToken());
		E = Double.parseDouble(br.readLine());
		pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.weight, e2.weight));
		visited = new boolean[N];
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
	}

	void solution() {
		visited[0] = true;
		addEdge(0);
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.v2]) continue;
			visited[e.v2] = true;
			result += e.weight;
			addEdge(e.v2);
		}
		result = Math.round(result * E);
	}

	void addEdge(int v1) {
		for (int v2 = 0; v2 < N; v2++) {
			if (visited[v2]) continue;
			pq.add(new Edge(v1, v2, Math.round(Math.pow(arrX[v1] - arrX[v2], 2) + Math.pow(arrY[v1] - arrY[v2], 2))));
		}
	}
}

class Edge {
	int v1, v2;
	long weight;

	Edge(int v1, int v2, long weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
}
