package ca.jrvs.practice.codingChallenge;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Challenge: Valid Parentheses
 * https://www.notion.so/jarvisdev/Valid-Parentheses-43867622584d4ca1a54c846d6faddccf
 */

public class ValidParentheses {

    public boolean isValid(String s) {

        List<Character> stc = s.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());
        Stack<Character> stack = new Stack<>();

        for(char c : stc){
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else if(c==')' && stack.peek()=='(')
                stack.pop();
            else if(c=='}' && stack.peek()=='{')
                stack.pop();
            else if(c==']' && stack.peek()=='[')
                stack.pop();
            else
                return false;
        }
        return true;
    }
}
