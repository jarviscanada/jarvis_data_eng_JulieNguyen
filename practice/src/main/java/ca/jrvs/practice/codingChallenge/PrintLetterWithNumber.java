package ca.jrvs.practice.codingChallenge;

/**Challenge: Print Letter With Number
 * https://www.notion.so/jarvisdev/Print-letter-with-number-a595b2068cb940f59f4ae31c3c386752
 */

public class PrintLetterWithNumber {

    //O(n) solution because there is a single for-loop iterating through the string of length n.
    public String printLetterWithNumber(String input){
        char [] arrIn = input.toCharArray();
        String result = "";
        for(char c : arrIn){
            result += c;
            result += (int) c - 96;
        }
        return result;
    }

}