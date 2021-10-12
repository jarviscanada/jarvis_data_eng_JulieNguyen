package ca.jrvs.practice.codingChallenge;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ValidPalindrome {

    /**
     * Challenge: Valid Palindrome
     * https://www.notion.so/jarvisdev/Valid-Palindrome-2e9fa45e0b34474a9f2fdac8a89273b6
     */

    public boolean isPalindrome(String s) {

        List<Character> reduce = s.toLowerCase()
                .replaceAll("[^0-9a-z]", "")
                .chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());

        if(reduce.size()==1)
            return true;

        int i = 0;
        int j = reduce.size()-1;

        while(i < j){
            if(reduce.get(i)!=reduce.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}