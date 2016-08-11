/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fiveamsolutions.interview;

import java.util.HashMap;

/**
 *
 * @author NewRodney
 */
public class AnagramFinderImpl implements AnagramFinder {

    public class CharacterCounter {
        private HashMap<Character, Integer> characterCounts = new HashMap<>();
        
        public CharacterCounter(String s)
        {
            String sc = s.toLowerCase();
            
            // Walk the string and update the characterCounts map for each character
            for (int i = 0; i < sc.length(); i++)
            {
                updateCharacterCount(sc.charAt(i));
            }
        }
        
        private void updateCharacterCount(Character c)
        {
            if (!Character.isWhitespace(c))
            {
                Integer i = characterCounts.get(c);
                
                if (i == null)
                    i = 0;
                
                i++;
                
                characterCounts.put(c, i);
            }
        }

        public boolean equals(CharacterCounter cc)
        {
            // If they aren't the same length, they aren't anagrams
            boolean retval = (characterCounts.size() == cc.characterCounts.size());
            
            // For each element in characterCounts, check if the same is found in cc
            if (retval)
            {
                for (Character c : characterCounts.keySet())
                {
                    retval = (characterCounts.get(c).equals(cc.characterCounts.get(c))) && retval;
                }
            }
            
            return retval;
        }
        
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AnagramFinderImpl af = new AnagramFinderImpl();
        
        af.testAnagrams("Rodney", "Yendor");
        af.testAnagrams("Postmaster", "Stamp Store");
        af.testAnagrams("Angels", "Angles");
        af.testAnagrams("Pudding", "Puffding");
        af.testAnagrams("PostMaster", "Stamp Story");
        af.testAnagrams("zzaayy", "ayazyz");
        af.testAnagrams("zzaayy", "ayrzyz");
        af.testAnagrams("aabbcczz", "aabbccdd");
    }
    
    public void testAnagrams(String s1, String s2)
    {
        System.out.println(s1 + " and " + s2 + " are anagrams: " + areAnagrams(s1, s2));
    }
    
    public boolean areAnagrams(String s1, String s2)
    {
        CharacterCounter cc1 = new CharacterCounter(s1);
        CharacterCounter cc2 = new CharacterCounter(s2);
        
        return cc1.equals(cc2);
    }
    
}
