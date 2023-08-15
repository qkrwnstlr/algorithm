class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int RT = 0;
        int CF = 0;
        int JM = 0;
        int AN = 0;
        for(int i = 0; i < survey.length; i++) {
            switch(survey[i]) {
                case "RT": RT += choices[i] - 4; break;
                case "CF": CF += choices[i] - 4; break;
                case "JM": JM += choices[i] - 4; break;
                case "AN": AN += choices[i] - 4; break;
                case "TR": RT += 4 - choices[i]; break;
                case "FC": CF += 4 - choices[i]; break;
                case "MJ": JM += 4 - choices[i]; break;
                case "NA": AN += 4 - choices[i]; break;
            }
        }
        if(RT <= 0) answer += "R";
        else answer += "T";
        if(CF <= 0) answer += "C";
        else answer += "F";
        if(JM <= 0) answer += "J";
        else answer += "M";
        if(AN <= 0) answer += "A";
        else answer += "N";
        return answer;
    }
}