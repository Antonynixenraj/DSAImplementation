package Sorting;
import LinkedList.SinglyLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntToDoubleFunction;


public class demo {
    public static void main(String[] args) {
       SinglyLinkedList lst=new SinglyLinkedList();
       lst.append(1);
       lst.prepend(2);

       List lst1=new List();
       lst1.append(1);
       lst1.append(56);
       lst1.append(12);
        // LinkedList<Integer> list=new LinkedList<>();
        // Queue<Integer> que =list;
        // que.add(12);
        // que.add(34);
        // que.add(67);
        // System.out.println(list.pop());
        // System.out.println(que.peek());
        // list.addFirst(12);

        // System.out.println(que);
        // System.out.println(list);



       System.out.println(lst);
        System.out.println(lst1);

    }

}
class List {


    // -------------------------- NODE CLASS ----------------------------------------------
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // -------------------------- ESSENTIAL METHODS ----------------------------------------------

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty(){
        return  head==null;
    }

    public void append(int val){
        Node node=new Node(val);
        if(isEmpty()){
            head=tail=node;
            size++;
            return;
        }

        tail.next=node;
        tail=node;
        size++;
    }
    public  void toPrint(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
