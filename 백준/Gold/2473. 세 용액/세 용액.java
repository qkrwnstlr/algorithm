import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader br;
	int N;
	long min;
	long[] arr;
	String result;

	void init() throws IOException {
		result = "";
		min = Long.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		System.out.println(result);
	}

	void solution() {
		for (int m = 0; m < N; m++) {
			int s = m + 1, e = N - 1;
			while (s < e) {
				long sum = arr[m] + arr[s] + arr[e];
				if (Math.abs(min) > Math.abs(sum)) {
					min = sum;
					result = arr[m] + " " + arr[s] + " " + arr[e];
				}
				if (sum < 0) {
					s++;
				} else if (sum > 0) {
					e--;
				} else {
					return;
				}
			}
		}
	}
}
