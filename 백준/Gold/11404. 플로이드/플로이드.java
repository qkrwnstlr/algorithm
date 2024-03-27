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
	long[][] graph;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new long[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			graph[u][v] = Math.min(graph[u][v], w);
		}
	}

	void run() throws IOException {
		init();
		solution();
		StringBuffer sb = new StringBuffer();
		Arrays.stream(graph).forEach(arr -> {
			Arrays.stream(arr).forEach(i -> sb.append(i == Integer.MAX_VALUE ? 0 : i).append(" "));
			sb.append("\n");
		});
		System.out.println(sb);
	}

	void solution() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}
}