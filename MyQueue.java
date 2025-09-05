package com.scs.oop_problems;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueue{" + "s1=" + s1 + ", s2=" + s2 + '}';
    }
    
    
    
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        q.push(30);
        
        System.out.println(q);

        System.out.println(q.pop()); // 10
        System.out.println(q.peek());    // 20
        
        Stack<Integer> mySt = new Stack<>();
        mySt.add(10);
        mySt.add(20);
        mySt.add(30);
        mySt.add(40);
        System.out.println("Normal stack:" + mySt);
        System.out.println("Peek: " + mySt.peek());
        System.out.println("pop: " + mySt.pop());
        mySt.remove(Integer.valueOf(30));
        System.out.println("Normal stack:" + mySt);


    }
}


