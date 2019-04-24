package leetcode.stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * https://leetcode.com/problems/valid-parentheses/
 * Created by jinjunzhu on 2019/4/1.
 */
public class ValidParentheses {


    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 > 0){
            return false;
        }
        char[] parenthes = new char[length];
        int j = 0;
        for (int i = 0; i < length; i++){
            if (j == 0){
                parenthes[j++] = s.charAt(i);
                continue;
            }
            if (!matches(parenthes[j - 1], s.charAt(i))){
                parenthes[j++] = s.charAt(i);
                continue;
            }else{
                j--;
            }
        }

        return j == 0;
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
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
    }
}
