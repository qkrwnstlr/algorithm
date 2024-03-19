import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int[] N, sorted;
	int M;
	String result;

	void init() throws IOException {
		result = "";
		st = new StringTokenizer(br.readLine());
		N = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(st.nextToken());
		sorted = Arrays.stream(N).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
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
		int lev = 0, top = -1;
		while (lev != M && ++top < N.length) {
			if (N[top] == sorted[top]) continue;
			int max = top;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = N.length - 1; i >= top + 1 ; i--) {
				if (N[max] > N[i]) continue;
				if (N[max] < N[i]) {
					max = i;
					list = new ArrayList<Integer>();
				}
				list.add(i);
			}
			if (N[max] <= N[top]) continue;

			List<Integer> list2 = new ArrayList<Integer>();
			for (int i = top; i < N.length; i++) {
				if(N[i] != N[max]) list2.add(i);
			}
			list2.sort((i1, i2) -> N[i1] - N[i2]);
			for (int i = 0; i < list2.size() && i < list.size(); i++) {
				max = list.get(i);
				if (list2.get(i) == top) break;
			}
			
			swap(max, top);
			lev++;
		}
		if ((M - lev) % 2 == 1) {
			for (int i = 0; i < N.length - 1; i++) {
				if(N[i] == N[i + 1]) {
					result = Arrays.stream(N).mapToObj((e) -> Integer.toString(e)).collect(Collectors.joining(""));
					return;
				}
			}
			swap(N.length - 1, N.length - 2);
		}
		result = Arrays.stream(N).mapToObj((e) -> Integer.toString(e)).collect(Collectors.joining(""));
	}
	
	void swap(int i, int j) {
		int temp = N[i];
		N[i] = N[j];
		N[j] = temp;
	}
}
