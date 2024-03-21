import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader br;
	StringTokenizer st;
	int[][] table;
	List<Set<Integer>> rSets, cSets, bSets;

	void init() throws IOException {
		table = new int[9][9];
		rSets = new ArrayList<>();
		cSets = new ArrayList<>();
		bSets = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			rSets.add(new HashSet<>());
			cSets.add(new HashSet<>());
			bSets.add(new HashSet<>());
		}

		for (int r = 0; r < 9; r++) {
			String line = br.readLine();
			for (int c = 0; c < 9; c++) {
				table[r][c] = line.charAt(c) - '0';
				if (table[r][c] == 0) continue;
				rSets.get(r).add(table[r][c]);
				cSets.get(c).add(table[r][c]);
				bSets.get((r / 3) * 3 + c / 3).add(table[r][c]);
			}
		}
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	void solution() {
		setValue(0);
	}

	boolean setValue(int index) {
		if (index == 9 * 9) return true;
		int r = index / 9;
		int c = index % 9;
		if (table[r][c] != 0) return setValue(index + 1);
		for (int i = 1; i <= 9; i++) {
			if (rSets.get(r).contains(i) || cSets.get(c).contains(i) || bSets.get((r / 3) * 3 + c / 3).contains(i)) continue;
			rSets.get(r).add(i);
			cSets.get(c).add(i);
			bSets.get((r / 3) * 3 + c / 3).add(i);
			table[r][c] = i;
			if (!setValue(index + 1)) {
				rSets.get(r).remove(i);
				cSets.get(c).remove(i);
				bSets.get((r / 3) * 3 + c / 3).remove(i);
				table[r][c] = 0;
			} else {
				return true;
			}
		}
		return false;
	}
}
