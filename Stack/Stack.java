/*
 * Implement a stack that has the following methods:
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
 * max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 * Each method should run in constant time.
 * 
 * @author Amazon
 * 
 * T.C:O(1) 
 * S.C:O(n)
 * 
 * ```Topic:Stack```
 */
public class Stack {
    int[] stack;
    int top;
    int max;

    public Stack(int size){
        stack = new int[size];
        max = size;
        top = -1;
    }

    public void push(int item){
        if(isFull()){
            System.out.println("Stack Overflowed!");
            return;
        }
        top++;
        stack[top] = item;
    }

    public  Integer pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        int poppedItem = stack[top];
        top--;
        return poppedItem;
    }

    public Integer max(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top == max - 1;
    }

    public int size(){
        return top + 1;
    }

    public static void main(String[] args) {
        Stack newStack = new Stack(6);

        newStack.push(1);
        newStack.push(27);
        newStack.push(53);
        newStack.push(94);
        newStack.push(34);
        newStack.push(69);
        
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.max());
    }
}
