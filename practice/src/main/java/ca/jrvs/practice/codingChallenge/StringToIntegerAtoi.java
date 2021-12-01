package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Challenge: String To Integer (Atoi)
 * https://www.notion.so/jarvisdev/String-to-Integer-atoi-a84929e43fb4481e8a21b5b6d34a126f
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        char[]ch = s.toCharArray();
        boolean hasDigit = false;
        String res = "";

        for(char c : ch){
            if(Character.isDigit(c)){
                res += c;
                hasDigit = true;
            }
            else if(c=='-'||c=='+'){
                if(res.equals("-")||res.equals("+")||hasDigit==true)
                    break;
                res += c;
            }
            else if(Character.isLetter(c)||!Character.isWhitespace(c)&&!Character.isDigit(c)){
                break;
            }
            else if(Character.isWhitespace(c)&&hasDigit==true){
                break;
            }
        }
        if(hasDigit){
            long result = Long.parseLong(res);

            if(result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else if(result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            return (int) result;
        }
        return 0;
    }

}
