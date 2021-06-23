package top.mask.task;

import java.util.Stack;

/**
 * 查找String的括号是否配对
 */
public class StringDemo {
    public static void main(String[] args) {

    }

    public boolean pattern(String string){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <string.length() ; i++) {
            char ch = string.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else if (ch == ')'){
                if (stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }
            if (!stack.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
