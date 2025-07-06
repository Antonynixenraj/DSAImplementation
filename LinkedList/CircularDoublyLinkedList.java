package LinkedList;

public class CircularDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        private Node next;
        private Node prev;
        private int data;
        public Node(int val){
            data=val;
        }
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public boolean append(int val){
        Node node =new Node(val);
        if(isEmpty()){
            node.next=node.prev=node;
            head=tail=node;
        }
        else{
            node.prev=tail;
            node.next=head;
            tail.next=node;
            head.prev=node;
            tail=node;
        }
        size++;
        return true;   
    }
    public boolean prepend(int val){
        if(isEmpty())
            return prepend(val);
        
        Node node=new Node(val);
        node.next=head;
        node.prev=tail;
        head.prev=node;
        tail.next=node;
        head=node;
        size++;
        return true;
    }
    public boolean insert(int ind,int val){
        if(ind<0)
            return false;
        else if(ind==0)
            return prepend(val);
        else if(ind>=size)
            return append(val);
        
        Node node=new Node(val);
        Node temp=head;
        for(int i=1;i<ind;i++)
            temp=temp.next;
        
        node.prev=temp;
        node.next=temp.next;
        temp.next.prev=node;
        temp.next=node;
        size++;
        return true;
        
    }
    public boolean deleteFirst(){
        if(size==1)
            head=tail=null;
        else{
            head=head.next;
            head.prev=tail;
            tail.next=head;
        }
        size--;
        return true;
    }
    public boolean deleteLast(){
        if(size==1)
            return deleteFirst();
        
        tail=tail.prev;
        tail.next=head;
        head.prev=tail;
        
        size--;
        return true;
    }
    public boolean delete(int ind){
        if(ind<0 || ind>=size)
            return false;
        else if(ind==0)  
            return deleteFirst();
        else if(ind==size-1)
            return deleteLast();

        Node temp=head;
        for(int i=0;i<ind;i++)
            temp=temp.next;
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        size--;
        return true;   
    }
    public Integer search(int val){
        if(isEmpty())
            return null;
    
        Node temp=head;
        do{
            if(temp.data==val)
                return val;
            temp=temp.next;
        }while(temp!=head);

        return null;
    }
    
    public String toString(){
        StringBuffer str=new StringBuffer("[");
        Node temp=head;
        while(temp.next!=head){
            str.append(temp.data+", ");
            temp=temp.next;
        }
        str.append(temp.data+"]");
        return new String(str);
    }
    
    public static void main(String[] args) {
        CircularDoublyLinkedList lst=new CircularDoublyLinkedList();
        lst.append(7);
        lst.append(45);
        lst.append(34);
        lst.append(21);
        lst.prepend(0);
        System.out.println(lst);
        lst.delete(4);
        System.out.println(lst);
        System.out.println(lst.search(45));
    }

    public static class LinkedList<A> {
        private class Node {
            A val;
            Node next;
            public Node(A val){
                this.val=val;
            }
        }
        public Node head;
        public Node tail;
        public int size;

        public boolean isEmpty(){
            return size==0;
        }
        public int length(){
            return size;
        }

        public String toString(){
            StringBuffer str=new StringBuffer("[");
            Node temp=head;
            while(temp!=null){
                if(temp.val.getClass().isArray()){
                    str.append(java.util.Arrays.toString((Object[])temp.val));
                }
                else
                    str.append(temp.val);
                temp=temp.next;
                if(temp!=null)
                    str.append(", ");
            }
            str.append("]");
            return new String(str);

        }
    // -------------------------- ADDING VALUES ----------------------------------------------
        public void prepend(A val){
            Node node=new Node(val);

            if(isEmpty()){
                head=tail=node;
                size++;
                return;
            }
            node.next=head;
            head=node;
            size++;

            return;
        }
        public void append(A val){
            Node node=new Node(val);
            if(isEmpty()){
                head=tail=node;
                size++;
                return;
            }

            tail.next=node;
            tail=node;
            size++;
            return;
        }

        public Object getValue(int ind){
            if(ind<0 || ind>=size)
                throw new IndexOutOfBoundsException("Index "+ind+" out of bounds for length "+size);

            Node temp=head;
            for(int i=0;i<ind;i++)
                temp=temp.next;
            return temp.val;
        }
        public static void main(String[] args) {
            LinkedList<Object> lst=new LinkedList<>();
            lst.append("hello");
            lst.prepend(Integer.MIN_VALUE);
            lst.append(new int[]{1,2,3});
            System.out.println(lst.getValue(0));
            System.out.println(lst);
            System.out.println(lst.getValue(2).getClass());
            SinglyLinkedList list=new SinglyLinkedList();
            list.append(56);
            list.append(23);
            list.prepend(0);
            lst.append(list);
            System.out.println(lst);
        }
    }
}
