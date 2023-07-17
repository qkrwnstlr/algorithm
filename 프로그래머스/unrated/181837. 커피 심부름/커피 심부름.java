import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Solution {
  public int solution(String[] order) {
    Map<String, List<String>> temp = Arrays.stream(order).collect(Collectors.groupingBy(e -> {
      if(e.contains("cafelatte")) return "cafelatte";
      else return "americano";
    }));
    int answer = 0;
    for(String k: temp.keySet()) {
      if(k.equals("cafelatte")) answer += temp.get(k).size() * 5000;
      else answer += temp.get(k).size() * 4500;
    }
    return  answer;
  }
}