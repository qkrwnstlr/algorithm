class Solution {
    public int solution(String binomial) {
        String[] parsedBinomial = binomial.split(" ");
        switch(parsedBinomial[1]) {
            case "+": return Integer.parseInt(parsedBinomial[0]) + Integer.parseInt(parsedBinomial[2]);
            case "-": return Integer.parseInt(parsedBinomial[0]) - Integer.parseInt(parsedBinomial[2]);
            case "*": return Integer.parseInt(parsedBinomial[0]) * Integer.parseInt(parsedBinomial[2]);
        }
        return 0;
    }
}