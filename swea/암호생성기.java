import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N;
	int[] temp = { 1, 2, 3, 4, 5 };
	String result;

	Queue<Integer> queue;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(br.readLine());

			N = 16;
			queue = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			int i = 0;
			while (i >= 0) {
				int current = queue.poll();
				int next = current - temp[i++ % temp.length];
				if (next <= 0) {
					next = 0;
					i = -1;
				}
				queue.add(next);
			}

			result = "";
			while (!queue.isEmpty()) {
				result += queue.poll() + " ";
			}

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}
