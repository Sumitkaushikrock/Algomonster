package com.example.AlgoMonsterLeetSolutions.simulation;
import java.util.*;

public class UnHappyFriends {
}

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        Map<Integer, Set<Integer>> prefMap = new HashMap<>();
        for(int[] p: pairs){
            pairMap.put(p[0], p[1]);
            pairMap.put(p[1], p[0]);
        }

        for(int i=0; i < preferences.length; i++){
            Set<Integer> set = new LinkedHashSet<>();
            prefMap.put(i, set);
            int currPair = pairMap.get(i);
            for(int p: preferences[i]){
                if(p == currPair){
                    break;
                }
                else{
                    set.add(p);
                }
            }
        }
        int unHappy =0;
        for(int i=0; i < n; i++){
            if(prefMap.get(i).size() == 0)
            {
                continue;
            }
            else{
                Set<Integer> myPref = prefMap.get(i);
                for(int preference: myPref){
                    Set<Integer> preferenceOfPreferredFriend = prefMap.get(preference);
                    if(preferenceOfPreferredFriend.contains(i)){
                        unHappy++;
                        break;
                    }
                }
            }
        }

        return unHappy;

    }
}