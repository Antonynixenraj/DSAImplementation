package LinkedList;

import java.util.List;

public class SinglyLinkedList {


// -------------------------- NODE CLASS ----------------------------------------------
    private class Node {
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }  
    }

 // -------------------------- ESSENTIAL METHODS ----------------------------------------------

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty(){
        return head==null;
    }
    public int length(){
        return size;
    }
    
    public String toString(){
        StringBuffer str=new StringBuffer("[");
        Node temp=head;
        while(temp!=null){
            str.append(temp.val);
            temp=temp.next;
            if(temp!=null)
                str.append(", ");
        }
        str.append("]");
        return new String(str);

    }
// -------------------------- ADDING VALUES ----------------------------------------------
    public void prepend(int val){
        Node node=new Node(val);

        if(isEmpty()){
            head=tail=node;
            size++;
            return;
        }
        node.next=head;
        head=node;
        size++;
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
    public boolean insert(int ind,int val){
        if(ind<0) return false;
        else if(ind==0){
            prepend(val);
            return true;       
        }
        
        else if(ind>=size){
            append(val);
            return true;
        }
        Node node=new Node(val);
        Node temp=head;
        for (int i = 1; i < ind; i++) 
            temp=temp.next;

        node.next=temp.next;
        temp.next=node;

        size++;
        return true;
        
    }
    public void appendArray(int arr[]){
        for (int i : arr) 
            append(i);
    }
// -------------------------- DELETE VALUES USING INDEX ----------------------------------------------
    public boolean deleteFirst(){
        if(isEmpty())
            return false;
        else if(size==1)
            head=tail=null;
        else
            head=head.next;
        size--;
        return true;

    }
    public boolean deleteLast(){
        if(isEmpty())
            return false;
        else if(size==1)
            return(deleteFirst());

        Node temp=head;
        while(temp.next.next!=null)
            temp=temp.next;
        temp.next=null;
        tail=temp;
        size--;
        return true;
    }
    public boolean delete(int ind){
        if(isEmpty() || ind>=size || ind<0)
            return false;
        else if(ind==0)
            return(deleteFirst());
        
        else if(ind==size-1)
            return(deleteLast());
        
        Node temp=head;
        for (int i = 1; i < ind; i++) 
            temp=temp.next;
        temp.next=temp.next.next;
        size--;
        return true;
    }

// -------------------------- REMOVE VALUES USING ELEMENT ----------------------------------------------

    public boolean remove(int val){
        Node temp=head;
        int ind=-1;
        while (temp!=null){
            ind++;
            if(temp.val==val)
                return(delete(ind));
            temp=temp.next;
        }
        
        return false;
    }

    public boolean removeAll(int val){
        Node temp=head;
        int ind=-1;
        boolean found=false;
        while (temp!=null){
            ind++;
            if(temp.val==val){
                delete(ind);
                ind--;     // This is check wheather same element move to same index
                found=true;        
            }
            temp=temp.next;
        }
        return found;

    }
// -------------------------- FETCH VALUES USING INDEX ----------------------------------------------
    public int getValue(int ind){
        if(ind<0 || ind>=size)
            throw new IndexOutOfBoundsException("Index "+ind+" out of bounds for length "+size);

        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;

        return temp.val;
    }

// -------------------------- UPDATE VALUE ----------------------------------------------

    public boolean update(int ind,int val){
        if(isEmpty() || ind>=size || ind<0) return false;
        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;
        temp.val=val;
        return true;
    }
// -------------------------- REVERSING LIST ------------------------------------------------
    public void reverse() {
        if(head==null || head.next==null) return;

        Node prev = null;
        Node current = head;
        Node next = head.next;
        
        while (next != null) {
            current.next=prev;
            prev=current;
            current=next;
            next=next.next;
        }
        tail=head;
        current.next=prev;
        head=current;
    }
        
    public SinglyLinkedList copy()
    {
        SinglyLinkedList lst=new SinglyLinkedList();
        Node temp=head;
        while (temp!=null) {
            lst.append(temp.val);
            temp=temp.next;
        }
        return lst;
    }
    public int[] toArray(){
        int arr[]=new int[size];
        Node temp=head;
        for(int i=0;temp!=null;i++){
            arr[i]=temp.val;
            temp=temp.next;
        }
        return arr;
    }
    public boolean equals(Object o){
        SinglyLinkedList lst=(SinglyLinkedList)o;
        if(head==null && lst.head==null)  return true;
        else if(size!=lst.size || head.val!=lst.head.val) return false;
        Node node1=head;
        Node node2=lst.head;
        while(node1!=null){
            if(node1.val!=node2.val)
                return false;
            node1=node1.next;
            node2=node2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        SinglyLinkedList lst=new SinglyLinkedList();
        lst.append(1);
        lst.prepend(2);

        SinglyLinkedList lst1=new SinglyLinkedList();
        lst1.append(1);
        lst1.append(56);
        lst1.append(12);
    }

}

