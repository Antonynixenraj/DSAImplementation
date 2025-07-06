package Queue;

public class DynamicArrayQueue{
    int arr[]=new int[5];
    int front=-1;
    int rear=-1;
    int size;
    public boolean isEmpty(){
        return front==-1;
    }
    public boolean isFull(){
        return (rear+1)%arr.length==front;
    }
    public boolean enqueue(int val){
        if(isFull())
            expandArray();
        else if(isEmpty())
            front++;
        rear=(rear+1)%arr.length;
        arr[rear]=val;
        size++;
        return true;
    }
    public int size()
    {
        return size;
    }
    public Integer top(){
        return isEmpty()?null:arr[front];
    }
    public void expandArray(){
        int[] temp=new int[arr.length*2];
        int ind=0;
        for(int i=front;i!=rear;i=(i+1)%arr.length)
            temp[ind++]=arr[i];
        temp[ind]=arr[rear];
        front=0;
        rear=ind;
        arr=temp;
    }
    public void shrinkArray(){
        int[] temp=new int[(arr.length/2)+1];
        int ind=0;
        for(int i=front;i!=rear;i=(i+1)%arr.length)
            temp[ind++]=arr[i];
        temp[ind]=arr[rear];
        front=0;
        rear=ind;
        arr=temp;
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
    public boolean dequeue(){
        if(isEmpty())
            return false;
        
        if(size<arr.length/2)
            shrinkArray();

        else if(rear==front)
            rear=front=-1;
        
        front=(front+1)%arr.length;
        size--;
        return true;
    }
     public static void main(String[] args) {
        DynamicArrayQueue que=new DynamicArrayQueue();
        que.enqueue(89);
        que.enqueue(98);
        que.enqueue(12);
        que.enqueue(83);
        que.enqueue(1234);
        que.enqueue(987);
        que.enqueue(91);
        que.dequeue();

        System.out.println(que.top());
        System.out.println(que);
        System.out.println(java.util.Arrays.toString(que.arr));
     }
}
