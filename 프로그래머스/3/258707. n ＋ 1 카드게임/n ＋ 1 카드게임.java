import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public int solution(int coin, int[] cards) {
    init(coin, cards);
    play();
    return answer;
  }

  int N, coin, answer;
  ArrayDeque<Integer> cards;
  ArrayList<Integer> lHands, rHands;

  private void init(int coin, int[] cards) {
    this.answer = 0;
    this.N = cards.length;
    this.coin = coin;
    this.cards = Arrays.stream(cards).boxed().collect(Collectors.toCollection(ArrayDeque::new));
    this.lHands = new ArrayList<>();
    rHands = new ArrayList<>();
    for (int i = 0; i < N / 3; i++) lHands.add(this.cards.pop());
  }

  private void play() {
    answer++;

    if (cards.isEmpty()) return;

    rHands.add(cards.pop());
    rHands.add(cards.pop());

    if (useCard(lHands)) {
      play();
    } else if (coin >= 1 && useCard(lHands, rHands)) {
      coin -= 1;
      play();
    } else if (coin >= 2 && useCard(rHands)) {
      coin -= 2;
      play();
    }
  }

  private boolean useCard(ArrayList<Integer> hands) {
    int l = 0, r = hands.size() - 1;
    hands.sort(Integer::compare);
    while (l < r) {
      Integer a = hands.get(l);
      Integer b = hands.get(r);
      int sum = a + b;
      if (sum == N + 1) {
        hands.remove(a);
        hands.remove(b);
        return true;
      } else if (sum < N + 1) {
        l++;
      } else if (sum > N + 1) {
        r--;
      }
    }
    return false;
  }

  private boolean useCard(ArrayList<Integer> lHands, ArrayList<Integer> rHands) {
    int l = 0, r = rHands.size() - 1;
    lHands.sort(Integer::compare);
    rHands.sort(Integer::compare);
    while (l < lHands.size() && r >= 0) {
      int sum = lHands.get(l) + rHands.get(r);
      if (sum == N + 1) {
        lHands.remove(lHands.get(l));
        rHands.remove(rHands.get(r));
        return true;
      } else if (sum < N + 1) {
        l++;
      } else {
        r--;
      }
    }
    return false;
  }
}