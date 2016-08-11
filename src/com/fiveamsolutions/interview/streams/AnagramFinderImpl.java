/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fiveamsolutions.interview.streams;

import com.fiveamsolutions.interview.*;

/**
 *
 * @author NewRodney
 */
public class AnagramFinderImpl implements AnagramFinder {

    public class SortedString {
 
        String sortedString;
        
        public SortedString(String s)
        {
            // Get a lowercase, sorted and trimmed version of the original string
            this.sortedString = s.toLowerCase()
                .codePoints().sequential()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().trim();
        }
        
        public boolean equals(SortedString cc)
        {
            return sortedString.equals(cc.sortedString);
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
        SortedString cc1 = new SortedString(s1);
        SortedString cc2 = new SortedString(s2);
        
        return cc1.equals(cc2);
    }
    
}
