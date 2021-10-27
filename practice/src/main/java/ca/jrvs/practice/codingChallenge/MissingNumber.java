package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    //O(n) solution where n is the number of elements in int[]nums as it has O(3n) for-loops = O(n)
    public int missingNumber(int[]nums) {
        int length = nums.length;

        int [] minmax = getMinMax(nums);

        if(minmax[1]+1==length)
            return minmax[1]+1;

        int sum = 0;
        for(int i=minmax[0]; i<=minmax[1]; i++){
            sum += i;
        } //may cause integer overflow if the value surpasses 32 bits.

        for(int num : nums){
            sum -= num;
        }

        if(sum!=0)
            return sum;
        else
            return 0;
    }

    public int[] getMinMax(int[]nums) {
        int max = nums[0];
        int min = 0;
        for(int num : nums){
            if(num>max)
                max = num;
        }
        int [] result = {min, max};
        return result;
    }

    //O(n)
    public int missingNumberUsingSet(int[]nums){
        Set<Integer> set = new HashSet<Integer>();

        int [] minmax = getMinMax(nums);
        if(minmax[1]+1==nums.length)
            return minmax[1]+1;

        for(int i=minmax[0]; i<=minmax[1]; i++){
            set.add(i);
        }

        for(int num : nums){
            if(set.contains(num))
                set.remove(num);
        }

        if(!set.isEmpty()) {
            for (int num : set) {
                return num;
            }
        }
        return 0;
    }

    //O(n)
    public int missingNumberUsingGauss(int[]nums){
        int length = nums.length;

        int [] minmax = getMinMax(nums);

        if(minmax[1]+1==length)
            return minmax[1]+1;

        int sum = (minmax[1]*(minmax[1]+1))/2; //gauss formula

        for(int num : nums){
            sum -= num;
        }

        if(sum!=0)
            return sum;
        else
            return 0;
    }

}