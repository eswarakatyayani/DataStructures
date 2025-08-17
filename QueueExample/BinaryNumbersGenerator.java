/*
Generate Binary Numbers from 1 to N using a Queue
Input: N = 5 → Output: ["1", "10", "11", "100", "101"]
*/

import java.util.*;
public class BinaryNumbersGenerator {

    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);

            // Generate next binary numbers and enqueue them
            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
}

/*
Step	  Queue	                                     Output
1	     ["1"]                               	        []
2	     ["10", "11"]	                                ["1"] 
3	     ["11", "100", "101"]	                        ["1", "10"]
4    	 ["100", "101", "110", "111"]	                ["1", "10", "11"]
5	     ["101", "110", "111", "1000", "1001"]	      ["1", "10", "11", "100"]
6	... (stop here)                                  	["1", "10", "11", "100", "101"]

*/
