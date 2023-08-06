public class Main {
    // -- Leetcode Debug --
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("words and 987"));
    }
}

class Solution {
    public int strToInt(String str) {
        char[] strarray = str.toCharArray();
        StringBuffer strRes = new StringBuffer();

        boolean isStarted = false;
        for(char cur : strarray){
            if(!isStarted){
                if(isNumber(cur)&&isNumber(cur)){
                    isStarted = true;
                    strRes.append(cur);
                }
            } else {
                if(isNumber(cur)){
                    strRes.append(cur);
                } else {
                    break;
                }
            }
        }

        int intRes = 0;
        String s = strRes.toString();
        intRes = Integer.parseInt(s);
        return intRes;
    }

    boolean isSign(char c){
        if(c=='+' || c=='-'){
            return true;
        } else {
            return false;
        }
    }

    boolean isNumber(char c){
        if(c=='1' || c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='0'){
            return true;
        } else {
            return false;
        }
    }
}