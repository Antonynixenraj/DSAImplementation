package LinkedList;

import java.util.EmptyStackException;

public class Stack {
    public class Node {
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    Node top;
    int size;
    public boolean isEmpty(){
        return top==null;
    }
    public void push(int val){
        Node node =new Node(val);
        node.next=top;
        top=node;
        size++;
    }
    public void pop(){
        if(isEmpty())
            throw new EmptyStackException();
        top=top.next;
        size--;
    }
    public int peek(){
       if(isEmpty())
            throw new EmptyStackException();
        return top.val; 
    }
    public String toString(){
        Node temp=top;
        StringBuilder str=new StringBuilder("[");
        while(temp!=null){
            str.append(temp.val);
            if(temp.next!=null)
                str.append(", ");
            temp=temp.next;
        }
        str.append("]");
        return new String(str);
    }
    public static void main(String[] args) {
        Stack stk=new Stack();
        stk.push(0);
        stk.push(89);
        stk.push(8932);
        stk.pop();
        stk.pop();
        stk.pop();
        System.out.println(stk.peek());
        System.out.println(stk);
    }

}
