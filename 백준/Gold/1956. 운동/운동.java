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
	long result;
	long[][] dist;
	boolean isPossible;

	void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new long[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			dist[u][v] = w;
		}
		result = Long.MAX_VALUE;
	}

	void run() throws IOException {
		init();
		solution();
		System.out.println(result == Long.MAX_VALUE ? -1 : result);
	}

	void solution() {
		floydWarshall();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE) {
					result = Math.min(result, dist[i][j] + dist[j][i]);
				}
			}
		}
	}

	void floydWarshall() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}