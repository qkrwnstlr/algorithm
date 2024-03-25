import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int K;
	String line, result;
	Set<String> subList;

	void init() throws IOException {
		result = "";
		K = Integer.parseInt(br.readLine());
		line = br.readLine();
		subList = new HashSet<>();
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
		br.close();
	}

	void solution() {
		for (int i = 0; i < line.length(); i++) {
			for (int j = i; j < line.length(); j++) {
				subList.add(line.substring(i, j + 1));
			}
		}

		try {
			result = subList.stream().sorted().toArray(String[]::new)[K - 1];
		} catch (Exception e) {
			result = "none";
		}
	}
}
