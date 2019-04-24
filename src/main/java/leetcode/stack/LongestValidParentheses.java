package leetcode.stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Created by jinjunzhu on 2019/4/1.
 */
public class LongestValidParentheses {

    public int longestValidParentheses1(String s) {
        int length = s.length();
        if (length < 2){
            return 0;
        }
        int[] point = new int[length];
        point[0] = -1;
        for (int i = 1; i < length; i ++ ){
            if (point[i-1] == -1){
                if (matches(s.charAt(i-1), s.charAt(i))){
                    point[i-1] = 1;
                    point[i] = 1;
                }else{
                    point[i] = -1;
                }
            }else{
                for (int j = i-2; j >=0; j--){
                    if (point[j] == -1){
                        if (matches(s.charAt(j),s.charAt(i))){
                            point[j] = 1;
                            point[i] = 1;
                            break;
                        }
                    }
                }
                if(point[i] == 0){
                    point[i] = -1;
                }
            }
        }


        int max = 0;
        int k = 0;
        for (int i = 0;i < point.length; i++){
            if (point[i] == 1){
                k ++;
                continue;
            }
            max = max > k ? max : k;
            k = 0;
        }
        return max > k ? max : k;
    }

    /**
     * 最优解
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2){
            return 0;
        }
        int[] point = new int[length];
        int m = 0;
        for (int i = 0; i < point.length; i++){
            point[i] = -1;
        }
        for (int i = 1; i < length; i ++ ){
            if (i > m){
                if (matches(s.charAt(m), s.charAt(i))){
                    point[i] = 1;
                    point[m] = 1;
                    for (int k = m; k >= 0; k--){
                        if (point[k] == -1){
                            m = k;
                            break;
                        }
                    }
                    if (point[m] == 1){
                        m = i+1;
                    }
                }else{
                    m = i;
                }
            }
        }

        int max = 0;
        int k = 0;
        for (int i = 0;i < point.length; i++){
            if (point[i] == 1){
                k ++;
                continue;
            }
            max = max > k ? max : k;
            k = 0;
        }
        return max > k ? max : k;
    }

    private boolean matches(char begin, char end){
        if ('(' == begin && ')' == end){
            return true;
        }
        if ('{' == begin && '}' == end){
            return true;
        }
        if ('[' == begin && ']' == end){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        LongestValidParentheses validParentheses = new LongestValidParentheses();
        System.out.println(validParentheses.longestValidParentheses("((()))())"));
    }


}
