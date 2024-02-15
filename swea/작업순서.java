import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;

	int V, E;
	Tesk[] tesks;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(testCase);

			V = Integer.parseInt(st.nextToken());
			tesks = new Tesk[V + 1];
			for (int i = 1; i <= V; i++) {
				tesks[i] = new Tesk(i);
			}

			E = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				Tesk preTesk = tesks[Integer.parseInt(st.nextToken())];
				Tesk postTesk = tesks[Integer.parseInt(st.nextToken())];

				preTesk.addPostTesk(postTesk);
				postTesk.addPreTesk();
			}

			Stack stack = new Stack(V + 1);
			for (int i = 1; i <= V; i++) {
				if (tesks[i].isAbleToStart()) {
					stack.push(i);
				}
			}

			while (!stack.isEmpty()) {
				Tesk current = tesks[stack.pop()];
				if (current.start()) {
					sb.append(" ").append(current.id);
					for (int i = 0; i < current.postTesks.size(); i++) {
						stack.push(current.postTesks.get(i).id);
					}
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}

class Stack {
	int[] arr;
	int top;

	Stack(int size) {
		arr = new int[size];
		top = -1;
	}

	void push(int data) {
		arr[++top] = data;
	}

	int pop() {
		return arr[top--];
	}

	int peek() {
		return arr[top];
	}

	boolean isEmpty() {
		return top == -1;
	}
}

class Tesk {
	int id;
	boolean isFinished;
	int leftPreTeskCount;
	List<Tesk> postTesks;

	Tesk(int id) {
		this.id = id;
		isFinished = false;
		this.postTesks = new ArrayList<>();
	}

	void addPreTesk() {
		this.leftPreTeskCount++;
	}

	void removePreTesk() {
		this.leftPreTeskCount--;
	}

	void addPostTesk(Tesk tesk) {
		this.postTesks.add(tesk);
	}

	boolean isAbleToStart() {
		return !this.isFinished && this.leftPreTeskCount == 0;
	}

	boolean start() {
		if (isAbleToStart()) {
			postTesks.forEach(Tesk::removePreTesk);
			return this.isFinished = true;
		} else {
			return false;
		}
	}
}
