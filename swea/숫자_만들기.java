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

	int N, max, min, result;
	int[] operators, values;
	List<String> madeOperators;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			N = Integer.parseInt(br.readLine());

			operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			madeOperators = new ArrayList<>();
			makeOperator(0, "");
			
			for (int i = 0; i < madeOperators.size(); i++) {
				calculate(madeOperators.get(i), 1, values[0]);
			}

			result = max - min;

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	void makeOperator(int depth, String result) {
		if (depth == N - 1) {
			madeOperators.add(result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				makeOperator(depth + 1, result + i);
				operators[i]++;
			}
		}
	}

	void calculate(String operator, int depth, int result) {
		if (depth == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		switch (operator.charAt(depth - 1)) {
		case '0':
			calculate(operator, depth + 1, result + values[depth]);
			break;
		case '1':
			calculate(operator, depth + 1, result - values[depth]);
			break;
		case '2':
			calculate(operator, depth + 1, result * values[depth]);
			break;
		case '3':
			calculate(operator, depth + 1, result / values[depth]);
			break;
		}
	}
}
