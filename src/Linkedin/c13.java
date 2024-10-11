package Linkedin;

import java.util.Stack;

public class c13 {
    public static void main(String[] args) {

    }
    public void push(int a,Stack<Integer> s)
    {
        s.push(a);
    }
    public int pop(Stack<Integer> s)
    {
        if(!s.isEmpty())
        {
            return s.pop();
        }
        return -1;
    }
    public int min(Stack<Integer> s)
    {
        int min=Integer.MAX_VALUE;
        while(s.isEmpty())
        {
            min=Math.min(min,s.pop());
        }
        return min;
    }
    public boolean isFull(Stack<Integer>s, int n)
    {
        return s.size()==n;
    }
    public boolean isEmpty(Stack<Integer>s)
    {
        return s.isEmpty();
    }
}
