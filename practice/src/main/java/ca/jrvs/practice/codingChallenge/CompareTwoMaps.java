package ca.jrvs.practice.codingChallenge;

import java.util.*;

/**Challenge: How To Compare Two Maps
 * https://www.notion.so/jarvisdev/How-to-compare-two-maps-9f39f0279e384b0fbb83dc171ad8f0d7
 */
public class CompareTwoMaps {

    //My solution
    public <K,V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2){
        Map<K,V> result = new HashMap<K, V>();

        //O(n): singular for-loop with notation of n
        for(K key : m1.keySet()){
            if(m1.get(key).equals(m2.get(key))){
                result.put(key, true);
            }
            else{
                result.put(key, false);
            }
        }

        return result;
    }

    //Online solution
}
