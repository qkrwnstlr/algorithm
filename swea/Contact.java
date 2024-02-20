import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}

	BufferedReader br;
	StringTokenizer st;
	StringBuilder sb;
	PersonManager pm;

	int N, start, result;

	void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			pm = new PersonManager(100);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				pm.addLink(from, to);
			}

			result = pm.startCall(start);

			sb.append(" ").append(result).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}

class PersonManager {
	Person[] personList;

	PersonManager(int size) {
		personList = new Person[size + 1];
		for (int i = 1; i <= size; i++) {
			personList[i] = new Person(i);
		}
	}

	void addLink(int from, int to) {
		personList[from].addPhone(to);
	}

	int startCall(int id) {
		Queue<Integer> queue = new LinkedList<>();
		Person result = personList[id];
		result.getCall();
		queue.add(result.id);

		while (!queue.isEmpty()) {
			Person current = personList[queue.poll()];
			if (result.priority < current.priority || (result.priority == current.priority && result.id < current.id)) {
				result = current;
			}
			List<Integer> phoneBook = current.phoneBook;
			for (int i = 0; i < phoneBook.size(); i++) {
				Person next = personList[phoneBook.get(i)];
				if (next.getCall()) {
					next.setPriority(current.priority + 1);
					queue.add(next.id);
				}
			}
		}

		return result.id;
	}
}

class Person {
	int id, priority;
	boolean isFinished;
	List<Integer> phoneBook;

	Person(int id) {
		this.id = id;
		phoneBook = new ArrayList<>();
	}

	void setPriority(int priority) {
		this.priority = priority;
	}

	void addPhone(int id) {
		phoneBook.add(id);
	}

	boolean getCall() {
		if (this.isFinished) {
			return false;
		}
		return this.isFinished = true;
	}
}
