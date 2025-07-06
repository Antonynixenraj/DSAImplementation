package Queue;

public class ListQueue {
    Node front;
    Node rear;
    int size;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public boolean isEmpty(){
        return front==null;
    }
    public boolean enque(int val){
        Node node=new Node(val);
        if(isEmpty())
            front=rear=node;
        rear.next=node;
        size++;
        return true;
    }
    public boolean dequeue(){
        if(isEmpty())
            return false;
        front=front.next;
        size--;
        return true;
    }
    public Integer top(){
        return front==null?null:front.val;
    }
    public int size(){
        return size;
    }
    public String toString(){
        StringBuilder str=new StringBuilder("[");
        Node temp=front;
        while (temp!=null) {
            str.append(temp.val);
            if(temp.next!=null)
                str.append(", ");
            temp=temp.next;
        }
        str.append("]");
        return new String(str);
    }
    public static void main(String[] args) {
        ListQueue que=new ListQueue();
        que.enque(43);
        que.enque(432);
        que.dequeue();
        que.dequeue();
        System.out.println(que);
    }
}
