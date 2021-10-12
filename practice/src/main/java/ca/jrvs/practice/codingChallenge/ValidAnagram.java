package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidAnagram {

    //O(nlogn)
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    //O(n)
    public boolean isAnagramON(String s, String t){
        if(s.length()!=t.length())
            return false;

        if(s.equals(t))
            return true;

        int [] count = new int[256];

        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }

        for(int i=0; i<count.length; i++){
            if(count[i]!=0)
                return false;
        }

        return true;
    }

}