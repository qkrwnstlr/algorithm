import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
		result = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			try {
				map.replace(arr[i], map.get(arr[i]) + 1);
			} catch (Exception e) {
				map.put(arr[i], 1);
			}
		}
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		System.out.println(result);
	}

	void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int value = arr[i] + arr[j];
				try {
					int count = map.get(value);
					if ((arr[i] == 0 || arr[j] == 0) && (count == 1)) continue;
					if ((arr[i] == 0 && arr[j] == 0) && (count == 2)) continue;
					result += count;
					map.remove(value);
				} catch (Exception e) {

				}
			}
		}
	}
}
