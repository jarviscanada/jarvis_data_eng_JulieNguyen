package ca.jrvs.practice.codingChallenge;

import java.util.regex.Pattern;

public class CheckIfOnlyDigits {

    //O(n) where n is the length of the string
    public boolean checkStringUsingRegex(String string){
        String regex = "[0-9]+";
        return Pattern.matches(regex, string);
    }

    //O(n)
    public boolean checkStringUsingAPI(String string){
        char [] arr = string.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(!Character.isDigit(arr[i]))
                return false;
        }
        return true;
    }

}