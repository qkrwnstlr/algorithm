import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int N, result;
	Node[] nodePool;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			N = Integer.parseInt(br.readLine());
			nodePool = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				nodePool[i] = new Node(i);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Node node = nodePool[Integer.parseInt(st.nextToken())];
				node.setValue(st.nextToken());
				if (st.hasMoreTokens()) {
					node.setLChild(Integer.parseInt(st.nextToken()));
					node.setRChild(Integer.parseInt(st.nextToken()));
				}
			}

			result = (int) calculate(1);

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

	double calculate(int id) {
		Node node = nodePool[id];
		double result = 0;
		switch (node.value) {
		case "+":
			result = calculate(node.lChild) + calculate(node.rChild);
			break;
		case "-":
			result = calculate(node.lChild) - calculate(node.rChild);
			break;
		case "*":
			result = calculate(node.lChild) * calculate(node.rChild);
			break;
		case "/":
			result = calculate(node.lChild) / calculate(node.rChild);
			break;
		default:
			result = Integer.parseInt(node.value);
		}
		return result;
	}
}

class Node {
	int id;
	String value;
	int lChild;
	int rChild;

	Node(int id) {
		this.id = id;
	}

	void setValue(String value) {
		this.value = value;
	}

	void setLChild(int id) {
		this.lChild = id;
	}

	void setRChild(int id) {
		this.rChild = id;
	}
}
