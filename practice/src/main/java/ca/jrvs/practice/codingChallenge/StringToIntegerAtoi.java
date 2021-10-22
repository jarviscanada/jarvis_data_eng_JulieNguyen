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
        List<Character> stc = s.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        String resultStr = "";
        boolean leading = true;

        for (char c : stc) {
            if (!leading) {
                if (Character.isDigit(c))
                    resultStr += c;
                else
                    break;
            }

            if (leading) {
                if (Character.isWhitespace(c)) {
                    //do nothing
                } else if (c == '+') {
                    resultStr += '+';
                } else if (c == '-') {
                    resultStr += '-';
                } else if (Character.isDigit(c)) {
                    leading = false;
                    resultStr += c;
                } else {
                    return 0;
                }
            }
        }

        long result = Long.parseLong(resultStr);

        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) result;
    }

}
