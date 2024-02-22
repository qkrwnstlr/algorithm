import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int result;
	int[] price, plan;
	List<String> madeOperators;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			result = price[3];

			planning(0, 0, 0);

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	void planning(int depth, int acount, int leftCount) {
		if (depth == 12) {
			result = Math.min(result, acount);
			return;
		}
		if (leftCount > 0) {
			planning(depth + 1, acount, leftCount - 1);
		} else {
			// 일일권 사용시
			planning(depth + 1, acount + price[0] * plan[depth], 0);
			// 한달권 사용시
			planning(depth + 1, acount + price[1], 0);
			// 세달권 사용시
			planning(depth + 1, acount + price[2], 2);
		}
	}
}
