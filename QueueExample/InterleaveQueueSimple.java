/*
Interleave the First Half of a Queue with the Second Half
Input: [1, 2, 3, 4]
Output: [1, 3, 2, 4]
*/

import java.util.*;
public class InterleaveQueueSimple {
    public static void interleaveQueue(Queue<Integer> queue) {
        int size = queue.size();
        if (size % 2 != 0) {
            System.out.println("Queue must have even number of elements");
            return;
        }

        Queue<Integer> firstHalf = new LinkedList<>();
        Queue<Integer> secondHalf = new LinkedList<>();

        // Step 1: Split queue into two halves
        for (int i = 0; i < size / 2; i++) {
            firstHalf.offer(queue.poll());
        }
        while (!queue.isEmpty()) {
            secondHalf.offer(queue.poll());
        }

        // Step 2: Interleave and add back to original queue
        while (!firstHalf.isEmpty()) {
            queue.offer(firstHalf.poll());
            queue.offer(secondHalf.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        interleaveQueue(queue);
        System.out.println(queue); // Output: [1, 3, 2, 4]

        Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        interleaveQueue(queue2);
        System.out.println(queue2); // Output: [10, 40, 20, 50, 30, 60]
    }
}


/*
offer(E e)
Purpose: Adds an element to the end (tail) of the queue.
Syntax:
queue.offer(element);
Returns:
true if the element was successfully added.
false if the queue has capacity restrictions and is full.
*/

/*
poll()
Purpose: Removes and returns the head (first element) of the queue.
Syntax:
E element = queue.poll();
Returns:
The head element (first in line).
null if the queue is empty.
*/
