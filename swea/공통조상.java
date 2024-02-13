import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	BufferedReader br;
	StringBuilder sb;
	StringTokenizer st;
	int V, E, v1, v2;

	Node[] tree;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());

			tree = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node(i);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				Node parent = tree[Integer.parseInt(st.nextToken())];
				Node child = tree[Integer.parseInt(st.nextToken())];
				child.setParent(parent);
				parent.addChild(child);
			}

			Node n1 = tree[v1];
			Node n2 = tree[v2];

			if (n1.depth > n2.depth) {
				while (n1.depth != n2.depth) {
					n1 = n1.parent;
				}
			} else {
				while (n1.depth != n2.depth) {
					n2 = n2.parent;
				}
			}

			while (n1.value != n2.value) {
				n1 = n1.parent;
				n2 = n2.parent;
			}

			count = 0;
			inorder(n1);

			sb.append("#").append(test_case).append(" ").append(n1.value).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}

	int count;

	void inorder(Node node) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < node.children.size(); i++) {
			inorder(node.children.get(i));
		}
		count++;
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}

class Node {
	Node parent;
	List<Node> children;
	int value;
	int depth;

	Node(int value) {
		this.children = new ArrayList<>();
		this.value = value;
	}

	void setParent(Node parent) {
		this.parent = parent;
		this.depth = this.parent.depth + 1;
		for (int i = 0; i < children.size(); i++) {
			children.get(i).setParent(this);
		}
	}

	void addChild(Node child) {
		children.add(child);
	}
}
