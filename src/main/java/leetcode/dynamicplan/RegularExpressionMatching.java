package leetcode.dynamicplan;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * Created by jinjunzhu on 2019/4/5.
 */
public class RegularExpressionMatching {

    /**
     * https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*' && match[0][i-1]){
                match[0][i+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    match[i+1][j+1] = match[i][j];
                }
                if (p.charAt(j) == '*'){
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        match[i+1][j+1] = match[i+1][j-1];
                    }else{
                        match[i+1][j+1] = (match[i+1][j] || match[i][j+1] || match[i+1][j-1]);
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }

}
