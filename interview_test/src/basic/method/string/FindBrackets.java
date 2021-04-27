package basic.method.string;

import java.util.Stack;

/**
 * @Author: Chenglin Ding
 * @Date: 21.04.2021 22:39
 * @Description:
 */
public class FindBrackets {
    public static void main(String[] args) {
        String str = "{([])}";
        Stack<Character> left = new Stack<>();
        for(int i = 0; i <str.length();i++){
            char a = str.charAt(i);
            System.out.println(a);
            if( a== '(' || a == '{' || a == '[')
                left.push(str.charAt(a));
            else{
                if(!left.empty() && leftof(a) == left.peek())
                    left.pop();
                else{
                    System.out.println("false");
                }
            }
        }
        if(left.empty()){
            System.out.println("true");
        }

    }

    public static char leftof(char c){
        if(c == '}') return '{';
        if(c == ')') return '(';
        return '[';
    }
}
