import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader br;
	StringTokenizer st;
	int N, result;
	int[] arr;
	Map<Integer, Integer> map;

	void init() throws IOException {
		result = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		System.out.println(result);
	}

	void solution() {
		loop: for (int e1 = 0; e1 < N; e1++) {
			for (int e2 = e1 + 1; e2 < N; e2++) {
				int elsa = arr[e1] + arr[e2];
				int a1 = 0, a2 = N - 1;
				while (a1 < a2) {
					if (a1 == e1 || a1 == e2) {
						a1++;
						continue;
					}
					if (a2 == e1 || a2 == e2) {
						a2--;
						continue;
					}
					int anna = arr[a1] + arr[a2];
					result = Math.min(result, Math.abs(elsa - anna));
					if (elsa < anna) {
						a2--;
					} else if (elsa == anna) {
						break loop;
					} else {
						a1++;
					}
				}
			}
		}
	}
}
