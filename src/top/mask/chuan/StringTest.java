package top.mask.chuan;

import java.util.Stack;

/**
 * ClassName StringTest
 * Create by hx
 * Date 2021/6/27 6:08 下午
 */

public class StringTest {
    public static void main(String[] args) {

    }

    public static boolean pattern(String string){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '('){
                stack.push('(');
            }else if (string.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return false;
    }
}
