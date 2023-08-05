import java.util.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(IntStream.range(0, b).mapToObj(e -> "*".repeat(a) + "\n").collect(Collectors.joining()));
    }
}