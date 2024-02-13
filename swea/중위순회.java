import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	BufferedReader br;
	StringBuilder sb, result;
	StringTokenizer st;
	int N;
	String[] tree;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				tree[i] = st.nextToken();
			}
			
			result = new StringBuilder();
			inorder(result, 1);

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}
	
	void inorder(StringBuilder sb, int index) {
		if(index > N) return;
		inorder(sb, index * 2);
		sb.append(tree[index]);
		inorder(sb, index * 2 + 1);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
