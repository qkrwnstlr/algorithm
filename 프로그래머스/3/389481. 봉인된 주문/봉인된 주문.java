import java.util.Arrays;

class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length()));
        for (String ban : bans) {
            if (stringToLong(ban) <= n) n++;
            else break;
        }

        return longToString(n);
    }

    public long stringToLong(String value) {
        long result = 0;
        for (char c: value.toCharArray()) result = result * 26 + c - 'a' + 1;
        return result;
    }

    public String longToString(long value) {
        StringBuilder result = new StringBuilder();
        while (value-- > 0) {
            result.append((char) ('a' + value % 26));
            value /= 26;
        }
        return result.reverse().toString();
    }
}