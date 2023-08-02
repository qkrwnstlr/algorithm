class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] user: db) {
            if(!id_pw[0].equals(user[0])) continue;
            if(id_pw[1].equals(user[1])) return "login";
            return "wrong pw";
        }
        return "fail";
    }
}