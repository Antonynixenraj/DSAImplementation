package Array;

import java.util.EmptyStackException;

public class DynamicStack {
    private int[] arr=new int[10];
    private int top=-1;

    public boolean isfull(){
        return top==arr.length-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean push(int value){
        // if(isfull())
        //     expandArray();
        arr[++top]=value;
        return true;
    }
    public void pop(){
        // if(top<arr.length/2)
        //     shrinkArray();
        top--;
    }
    public Integer peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return arr[top];
    }
    public String toString(){
        StringBuilder str=new StringBuilder("[");
        for(int i=0;i<=top;i++){
            str.append(arr[i]);
            if(i!=top)
                str.append(", ");
        }
        str.append("]");
        return new String(str);
    }
    public void expandArray(){
        int[] temp=arr;
        arr=new int[arr.length*2];
        for(int i=0;i<=top;i++){
            arr[i]=temp[i];
        }
    }
    public void shrinkArray(){
        int[] temp=arr;
        arr=new int[arr.length/2];
        for(int i=0;i<=top;i++){
            arr[i]=temp[i];
        }
    }
    public static void main(String[] args) {
        DynamicStack stk=new DynamicStack();
        stk.push(12);
        stk.push(34);
        stk.pop();
        System.out.println(stk);
        System.out.println(stk.peek());
        System.out.println(stk.top);
    }
}