import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    Organization organization = new Organization();

    Arrays.stream(enroll).forEach(organization::addSeller);

    for (int i = 0; i < referral.length; i++) {
      if (!Objects.equals(referral[i], "-")) {
        organization.addReferral(enroll[i], referral[i]);
      }
    }

    for (int i = 0; i < seller.length; i++) {
      organization.addAmount(seller[i], amount[i] * 100);
    }

    return Arrays.stream(enroll).mapToInt(it -> organization.sellers.get(it).amount).toArray();
  }
}

class Organization {
  Map<String, Seller> sellers;

  Organization() {
    sellers = new HashMap<>();
  }

  void addSeller(String seller) {
    sellers.put(seller, new Seller());
  }

  void addReferral(String from, String to) {
    sellers.get(from).setReferral(sellers.get(to));
  }

  void addAmount(String seller, int amount) {
    sellers.get(seller).addAmount(amount);
  }
}

class Seller {
  int amount;
  Seller referral;

  void setReferral(Seller referral) {
    this.referral = referral;
  }

  void addAmount(int amount) {
    int duty = amount / 10;
    this.amount += amount - duty;
    if (this.referral == null) return;
    this.referral.addAmount(duty);
  }
}