package Queue;

public class ArraysQueue {
    private int arr[]=new int[10];
    private int front=-1;
    private int rear=-1;
    private int size=0;
    public boolean isEmpty(){
        return front==-1;
    }
    public boolean isFull(){
        return (rear+1)%arr.length==front;
    }
    public int size(){
        return size;
    }
    public boolean enqueue(int val){
        if(isFull())
            return false;
        else if(isEmpty())
            front=0;
        rear=(rear+1)%arr.length;
        arr[rear]=val;
        size++;
        return true;
    }
    public boolean dequeue(){
        if(isEmpty())
            return false;
        else if(front==rear)
            front=rear=-1;
        else 
            front=(front+1)%arr.length;
        size--;
        return true;
    }
    public Integer front(){
        return isEmpty()?null:arr[front];
    }


    public String toString(){
        StringBuilder str=new StringBuilder("[");
        for(int i=front;i!=rear;i=(i+1)%arr.length){
            str.append(arr[i]);
            if(i!=rear)
                str.append(", ");
        }
        if(rear!=-1)
            str.append(arr[rear]);
        str.append("]");
        
        return new String(str);
    }
    public static void main(String[] args) {
        ArraysQueue que=new ArraysQueue();
        que.enqueue(89);
        que.enqueue(98);
        que.enqueue(12);
        que.enqueue(83);
        que.enqueue(1234);
        que.enqueue(120);
        que.dequeue();
        que.dequeue();
        que.dequeue();
        que.dequeue();
        que.dequeue();
        // que.enqueue(1);
        // que.enqueue(2);
        // que.enqueue(3);
        // que.enqueue(4);
        // que.enqueue(4);

        
        System.out.println(que);
        System.out.println(que.front());
    }
}
