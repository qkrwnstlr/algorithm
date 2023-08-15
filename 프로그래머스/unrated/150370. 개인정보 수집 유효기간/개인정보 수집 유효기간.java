import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : terms) {
            String[] temp = s.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        for(int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            if(compareDate(today, addMonth(temp[0], map.get(temp[1]))) >= 0) answer.add(i + 1);
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
    
    int compareDate(String d1, String d2) {
        String[] temp1 = d1.split("\\.");
        String[] temp2 = d2.split("\\.");
        return temp1[0].equals(temp2[0]) ? temp1[1].equals(temp2[1]) ? Integer.parseInt(temp1[2]) - Integer.parseInt(temp2[2]) : Integer.parseInt(temp1[1]) - Integer.parseInt(temp2[1]) : Integer.parseInt(temp1[0]) - Integer.parseInt(temp2[0]);
    }
    
    String addMonth(String date, int month) {
        String[] temp = date.split("\\.");
        int tempMonth = Integer.parseInt(temp[1]) + month - 1;
        return "" + (Integer.parseInt(temp[0]) + tempMonth / 12) + "." + String.format("%02d", tempMonth % 12 + 1) + "." + temp[2];
    }
}