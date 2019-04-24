package leetcode.stack;

/**
 * ["4", "13", "5", "/", "+"]
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Created by jinjunzhu on 2019/4/2.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }

        int length = tokens.length/2;
        int[] number = new int[length + 1];
        String[] to = new String[length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < tokens.length ; i++){
            int result = -1;
            if (isToken(tokens[i])){
                if (m > 1){
                    switch (tokens[i]){
                        case "*":
                            result = number[m-2]*number[m-1];
                            break;
                        case "/":
                            result = number[m-2]/number[m-1];
                            break;
                        case "+":
                            result = number[m-2]+number[m-1];
                            break;
                        case "-":
                            result = number[m-2]-number[m-1];
                            break;
                    }
                    number[m-2] = result;
                    m --;
                }else{
                    to[n++] = tokens[i];
                }
            }else{
                number[m++] = Integer.valueOf(tokens[i]);
            }
        }
        return number[0];
    }

    private boolean isToken(String token){
        return "*".equals(token) || "/".equals(token) || "+".equals(token) || "-".equals(token);
    }

    public static void main(String[] args){
        String tokens[] = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));

    }
}
