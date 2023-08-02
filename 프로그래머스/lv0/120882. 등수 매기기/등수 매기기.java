import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        Student[] sorted = IntStream.range(0, score.length).mapToObj(i -> new Student(i, Arrays.stream(score[i]).sum())).sorted(Comparator.comparingInt(Student::getScore).reversed()).toArray(Student[]::new);
        int currentRank = 1;
        int beforeScore = 0;
        int count = 0;
        for(Student student: sorted) {
            if(beforeScore != student.score) {
                answer[student.index] = currentRank++;
                beforeScore = student.score;
                count = 0;
            }
            else answer[student.index] = currentRank++ - ++count;
        }
        return answer;
    }
    
    class Student {
        int index;
        int score;

        public Student(int index, int score) {
            this.index = index;
            this.score = score;
        }

        int getScore() {
            return score;
        }
      }
}