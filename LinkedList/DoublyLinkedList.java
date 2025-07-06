package LinkedList;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val=val;
        }
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public boolean append(int val){
        Node node=new Node(val);
        if(isEmpty()){
            head=tail=node;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
        return true;
    }
    public boolean prepend(int val){
        if(isEmpty())
            return append(val);

        Node node=new Node(val);
        head.prev=node;
        node.next=head;
        head=node;
        size++;
        return true;
    }
    public boolean insert(int ind,int val){
        if(ind<0)   return false;
        else if(ind==0)
            return prepend(val);
        else if(ind>=size)
            return append(val);
        
        Node node =new Node(val);
        Node temp=head;
        for(int i=1;i<ind;i++)
            temp=temp.next;

        node.prev=temp;
        node.next=temp.next;
        temp.next=node;
        node.next.prev=node;

        size++;
        return true;
        
    }
    public boolean deleteFirst(){
        if(isEmpty())
            return false;
        else if(size==1)
            head=tail=null;
        else{
            head=head.next;
            head.prev=null;
        }
        size--;
        return true;
    }
    public boolean deleteLast(){
        if(isEmpty() || size==1)
            return deleteFirst();
        tail=tail.prev;
        tail.next=null;
        size--;
        return true;
    }
    public boolean delete(int ind){
        if(ind>=size || ind<0)  return false;

        else if(ind==0) return deleteFirst();

        else if(ind==size-1)    return deleteLast();

        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        size--;
        return true;
    }

    public int getValue(int ind){
        if(ind<0 || ind>=size)
            return -1;

        else if(ind ==0)
            return head.val;

        else if(ind==size-1)
            return tail.val;

        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;
        return temp.val;
        
    }
    public void reverse(){
        if(head==null || head.next==null)   return;
        Node temp=head;
        while (temp!=null) {
            //Swapping next and prev
            Node temp1=temp.next;
            temp.next=temp.prev;
            temp.prev=temp1;
            //Because of swapped we want to traverse back
            temp=temp.prev;
        }
        //Swapping head and tail
        Node temp1=tail;
        tail=head;
        head=temp1;
    }
    public String toString(){
        StringBuffer str=new StringBuffer("[");
        Node temp=head;
        while (temp!=null) {
            str.append(temp.val);
            if(temp!=tail)
                str.append(", ");
            temp=temp.next;
        }
        str.append("]");
        return new String(str);
    }

    public static void main(String[] args) {
        DoublyLinkedList lst=new DoublyLinkedList();
        lst.append(0);
        lst.append(6);
        lst.append(5);
        lst.prepend(1);
        lst.insert(1, 20);
        System.out.println(lst);

        lst.reverse();
        System.out.println(lst);

        System.out.println(lst.getValue(3));  
        
    }
    
}
