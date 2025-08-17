/*
First Non-Repeating Character 
Problem:
Given a string, find the first non-repeating character and return its index. If it doesn't exist, return -1.
Example:
Input: "leetcode" → Output: 0

*/
import java.util.*;
public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find first unique char
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));      // Output: 0
        System.out.println(firstUniqChar("loveleetcode"));  // Output: 2
        System.out.println(firstUniqChar("aabb"));          // Output: -1
    }
}
