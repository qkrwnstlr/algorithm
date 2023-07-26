import java.util.*;

class Solution {
    public String solution(String a, String b) {
        int carry = 0;
        String[] arrA = (new StringBuffer(a)).reverse().toString().split("");
        String[] arrB = (new StringBuffer(b)).reverse().toString().split("");
        StringBuilder answer = new StringBuilder();
        int max = Integer.max(arrA.length, arrB.length);
        int min = Integer.min(arrA.length, arrB.length);
        for(int i = 0; i < min; i++) {
            int temp = Integer.parseInt(arrA[i]) + Integer.parseInt(arrB[i]) + carry;
            carry = temp / 10;
            answer.append(temp % 10);
        }
        if(arrA.length > arrB.length) {
            for(int i = min; i < max; i++) {
                int temp = Integer.parseInt(arrA[i]) + carry;
                carry = temp / 10;
                answer.append(temp % 10);
            }
        } else if(arrA.length < arrB.length) {
            for(int i = min; i < max; i++) {
                int temp = Integer.parseInt(arrB[i]) + carry;
                carry = temp / 10;
                answer.append(temp % 10);
            }
        } 
        if(carry == 1) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }
}