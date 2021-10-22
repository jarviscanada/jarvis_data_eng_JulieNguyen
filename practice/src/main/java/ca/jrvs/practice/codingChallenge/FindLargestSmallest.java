package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindLargestSmallest {

    //O(n) for-loop approach
    public int findLargest(int[]arr){
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

    public int findSmallest(int[]arr){
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min)
                min=arr[i];
        }
        return min;
    }

    //Stream API approach O(n) as stream filtering uses iteration internally
    public int findLargestUsingStream(int[]arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    public int findSmallestUsingStream(int[]arr){
        return Arrays.stream(arr).min().getAsInt();
    }

    //Built-in API O(n)
    public int findLargestUsingAPI(int[]arr){
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        return Collections.max(list);
    }

    public int findSmallestUsingAPI(int[]arr){
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        return Collections.min(list);
    }

}