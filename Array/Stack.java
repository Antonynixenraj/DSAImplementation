package DataStructuresImplementation.Array;

public class Stack {
    private int[] arr=new int[10];
    private int top=-1;

    public boolean isfull(){
        return top==arr.length-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean push(int value){
        if(isfull())
            return false;
        arr[++top]=value;
        return true;
    }
    public void pop(){
        top--;
    }
    public Integer peek(){
        return isEmpty()?null:arr[top];
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
    public static void main(String[] args) {
        Stack stk=new Stack();
        stk.push(12);
        stk.push(34);
        stk.pop();
        System.out.println(stk);
        System.out.println(stk.peek());
    }
}