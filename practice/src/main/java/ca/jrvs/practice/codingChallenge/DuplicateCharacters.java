package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Challenge: Duplicate characters
 * https://www.notion.so/jarvisdev/Duplicate-Characters-87be1f9490c54b4eb7aeb0adcbf52c81
 */

public class DuplicateCharacters {

    //O(n)
    public char[] findDuplicates(String str){
        String input = str.toLowerCase();
        char[] ch = input.toCharArray();
        Map<Character, Boolean> duplicates = new HashMap<Character, Boolean>();

        for(char c : ch){
            if(duplicates.containsKey(c)&&!Character.isWhitespace(c))
                duplicates.put(c, true);
            else
                duplicates.put(c, false);
        }

        List<Character> list = new ArrayList<Character>();
        for(Character key : duplicates.keySet()){
            if(duplicates.get(key)==true)
                list.add(key);
        }

        char[]result = new char[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }
        return result;
    }

}