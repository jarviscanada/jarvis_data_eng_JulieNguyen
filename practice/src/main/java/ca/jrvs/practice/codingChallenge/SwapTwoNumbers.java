package ca.jrvs.practice.codingChallenge;

/**Challenge: Swap Two Numbers
 * https://www.notion.so/jarvisdev/Swap-two-numbers-7a70a84b5409476b9fe791208ec831e4
 */

public class SwapTwoNumbers {

    //Using bitwise operators
    public int[] swapTwoNumbers(int[]numbers){;
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

    //Using arithmetic functions
    public int[] swapTwoNumbersArithmetic(int[]numbers){;
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = Math.abs(numbers[0] - numbers[1]);
        return numbers;
    }

}