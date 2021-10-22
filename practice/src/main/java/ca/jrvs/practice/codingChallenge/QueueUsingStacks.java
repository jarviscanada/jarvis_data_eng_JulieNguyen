package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

/**
 * Challenge: Implement Queue Using Stacks
 * https://www.notion.so/jarvisdev/Implement-Queue-using-Stacks-50fff21da9e64256b745afd33a93a47b
 */
public class QueueUsingStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int first;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack1.empty())
            first = stack1.push(x);
        else
            stack1.push(x);
    }

    public int pop() {
        while(stack1.size()>1){
            stack2.push(stack1.pop());
        }
        int pop = stack1.pop();
        while(!stack2.isEmpty()){
            if(stack1.isEmpty())
                first = stack1.push(stack2.pop());
            else
                stack1.push(stack2.pop());
        }
        return pop;
    }

    public int peek() {
        return first;
    }

    public boolean empty() {
        if(stack1.isEmpty())
            return true;
        return false;
    }

}