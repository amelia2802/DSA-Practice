/**
 * Implement a stack API using only a heap. A stack implements the following methods:
 * push(item), which adds an element to the stack
 * pop(), which removes and returns the most recently added element (or throws an error if there is nothing on the stack)
 * Recall that a heap has the following operations:
 * 
 * push(item), which adds a new key to the heap
 * pop(), which removes and returns the max value of the heap
 * 
 * @author Amazon
 * 
 * T.C: 
 * S.C:
 * ```Topic:Stack & Heap```
 */

import java.util.*;

class StackByHeap {
    private static class Element {
        int timestamp;
        int value;

        Element(int timestamp, int value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private PriorityQueue<Element> maxHeap;
    private int timestamp;

    public StackByHeap() {
        // Max-Heap based on timestamp
        maxHeap = new PriorityQueue<>(Comparator.comparingInt((Element e) -> -e.timestamp));
        timestamp = 0;
    }

    // Push operation
    public void push(int value) {
        maxHeap.add(new Element(timestamp++, value));
    }

    // Pop operation
    public int pop() {
        if (maxHeap.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxHeap.poll().value;
    }

    // Max operation (peek the top element)
    public int max() {
        if (maxHeap.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxHeap.peek().value;
    }

    public static void main(String[] args) {
        StackByHeap stack = new StackByHeap();

        stack.push(1);
        stack.push(27);
        stack.push(53);
        stack.push(94);
        stack.push(34);
        stack.push(69);

        System.out.println(stack.pop()); // 69
        System.out.println(stack.pop()); // 34
        System.out.println(stack.max()); // 94
    }
}
