import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, M, result, odd, even;
	String[] code;
	Map<String, Integer> decoder = new HashMap<String, Integer>() {
		{
			put("0001101", 0);
			put("0011001", 1);
			put("0010011", 2);
			put("0111101", 3);
			put("0100011", 4);
			put("0110001", 5);
			put("0101111", 6);
			put("0111011", 7);
			put("0110111", 8);
			put("0001011", 9);
		}
	};

	void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		code = new String[N];
		for (int i = 0; i < N; i++) code[i] = br.readLine();
		result = odd = even = 0;
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
	}

	void solution() {
		int x = 0, y = M - 1;
		for (x = 0; x < N; x++) {
			for (y = M - 1; y >= 0; y--) {
				if (code[x].charAt(y) == '1') break;
			}
			if (y != -1) break;
		}
		y -= 7 * 8 - 1;
		for (int i = 0; i < 8; i += 2) {
			odd += decoder.get(code[x].substring(y, y += 7));
			even += decoder.get(code[x].substring(y, y += 7));
		}
		if ((odd * 3 + even) % 10 == 0) result = odd + even;
	}

}
