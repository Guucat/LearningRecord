package leetcode_zj100.bank20;

import java.util.Stack;

/**
 * @author shengyi
 * @create 2021/8/20 - 20:05
 * ok
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char tmp;
        stack.push('#');
        for (char c :chars) {
            tmp = stack.pop();
            if ((tmp == '(' && c == ')') || (tmp == '[' && c == ']') || (tmp == '{' && c == '}')){

            } else {
                stack.push(tmp);
                stack.push(c);
            }
        }
        stack.pop();
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("OK");

    }
}
