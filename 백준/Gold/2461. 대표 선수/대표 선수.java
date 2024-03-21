import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader br;
	StringTokenizer st;
	int N, M;
	long result;
	int[] indexes;
	long[][] scores;

	void init() throws IOException {
		result = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		scores = new long[N][M];
		for (int i = 0; i < N; i++) {
			scores[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
		}
		indexes = new int[N];
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		System.out.println(result);
	}

	void solution() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((c1, c2) -> scores[c1][indexes[c1]] - scores[c2][indexes[c2]] < 0 ? -1 : 1);
		int maxC = 0;
		for (int c = 0; c < N; c++) {
			pq.add(c);
			if (scores[maxC][indexes[maxC]] < scores[c][indexes[c]]) maxC = c;
		}
		while (!pq.isEmpty()) {
			int minC = pq.poll();
			result = Math.min(result, Math.abs(scores[minC][indexes[minC]] - scores[maxC][indexes[maxC]]));
			if (++indexes[minC] == M) break;
			if (scores[maxC][indexes[maxC]] < scores[minC][indexes[minC]]) maxC = minC;
			pq.add(minC);
		}
	}
}
