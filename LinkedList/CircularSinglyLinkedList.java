package LinkedList;

public class CircularSinglyLinkedList{
    private Node head;
    private Node tail;
    private int size=0;
    private class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
        }

    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int ind,int val){
        if(ind<0)  return false;

        Node node=new Node(val);
        if(isEmpty()){
            node.next=node;
            head=tail=node;
        }
        else if(ind==0){
            node.next=head;
            head=node;
            tail.next=head;
             
        }
        else if(ind>=size-1){ 
            tail.next=node;
            node.next=head;
            tail=node;
        }
        else
        {
            Node temp=head;
            for (int i = 0;i<ind-1; i++) 
                temp=temp.next;
            node.next=temp.next;
            temp.next=node;
        }
        size++;
        return true;
    }
    public boolean append(int val){
        return insert(size, val);
    }
    public boolean prepend(int val){
        return insert(0, val);
    }
    public boolean delete(int ind){
        if(ind>=size || ind<0)   return false;
        if(size==1)
            head=tail=null;
        else if(ind==0){
            head=head.next;
            tail.next=head;
        }
    
        else{
            Node temp=head;
            for(int i=1;i<ind;i++)
                temp=temp.next;
            temp.next=temp.next.next;
        }
        size--;
        return true;
    }
    public boolean deleteFirst(){
        return delete(0);
    }
    public boolean deleteLast(){
        return delete(size-1);
    }
    public String toString(){
        if(head==null)
            return "[]";

        StringBuffer str=new StringBuffer("[");
        Node temp=head;
        do{
            str.append(temp.data+", ");
            temp=temp.next;
        }while (temp.next!=head);
        str.append(temp.data+"]");
        return new String(str);
    }
    public int getValue(int ind){
        if(ind<0 || ind>=size)
            throw new IndexOutOfBoundsException("Index "+ind+" out of bounds for length "+size);
        else if(ind ==0)
            return head.data;
        else if(ind==size-1)
            return tail.data;
        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;
        return temp.data;
        
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList lst=new CircularSinglyLinkedList();
        lst.append(1);
        lst.append(2);
        lst.append(3);
        lst.prepend(0);

        System.out.println(lst);
        System.out.println(lst.getValue(3));
    }
}
