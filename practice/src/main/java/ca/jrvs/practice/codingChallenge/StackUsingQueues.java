package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Challenge: Implement Stack Using Queue
 * https://www.notion.so/jarvisdev/Implement-Stack-using-Queue-0d0f28f7eccd4057a94905231d09ac06
 */

public class StackUsingQueues {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        while(queue1.size()>1) {
            top = queue1.remove();
            queue2.add(top);
        }
        int popped = queue1.remove();

        queue1 = queue2;
        queue2 = new LinkedList<>();

        return popped;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        if(queue1.isEmpty())
            return true;
        return false;
    }
}