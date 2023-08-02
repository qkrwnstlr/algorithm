import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, List<Integer>> temp = Arrays.stream(array).boxed().collect(Collectors.groupingBy(e -> e));
        Data[] data = temp.keySet().stream().map(e -> new Data(e, temp.get(e).size())).sorted().toArray(Data[]::new);
        return Arrays.stream(data).filter(e -> e.count == data[data.length - 1].count).count() == 1 ? data[data.length - 1].value : -1;
    }
    
    class Data implements Comparable<Data>{
        int value;
        int count;
        Data(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Data o) {
            return count - o.count;
        }
    }
}