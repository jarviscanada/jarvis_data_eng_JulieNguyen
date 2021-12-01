package ca.jrvs.practice.codingChallenge;

/**
 * Challenge: Fibonacci Number/Climbing Stairs
 * https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-e4bfbf26d4854b5a9534c64b19f12e1f
 */
public class FibonacciClimbingStairs {
    /**
     * Time complexity O(n), linear
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    //Using dynamic programming
    public int fibDP(int n){
        int [] result = new int [31];
        result[0] = 0;
        result[1] = 1;

        for(int i=2; i<=30; i++){
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }

    /**
     * Time complexity O(n), linear
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] result = new int[46];
        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i < 46; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }

    //Using recursion
    public int climbStairsRec(int n){
        if(n==1||n==2)
            return n;
        else
            return climbStairsRec(n-1) + climbStairsRec(n-2);
    }

}
