package ca.jrvs.practice.codingChallenge;

import java.util.*;

/**Challenge: How To Compare Two Maps
 * https://www.notion.so/jarvisdev/How-to-compare-two-maps-9f39f0279e384b0fbb83dc171ad8f0d7
 */
public class CompareTwoMaps {

    /**
     * Time complexity is O(n) as it contains only one for-loop which iterates through each element of the two maps only once.
     *
     * @param m1
     * @param m2
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2){
        if(m1.size()!=m2.size()){
            return false;
        }
        for ( K key : m1.keySet() ) {
            if(!m1.get(key).equals(m2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
